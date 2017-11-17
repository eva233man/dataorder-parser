dataorder-parser
====
数据工单解析，用于数据库之间表对表同步

整体逻辑上分成三部分：配置、数据、数据解析落地

    配置逻辑关系：
    1.原表对目标表为1：n关系，chg表也认为是一个目标表
    2.原表字段与目标表字段为1：1关系

    配置信息注册实现通过db（数据库）的方式加载配置，并且预留接口，也可以支持其他模式的加载策略

具体类图如下：
![](https://github.com/eva233man/dataorder-parser/blob/master/frame.png) 

接下来是数据

    传输过来的数据工单一定是String的字符串，格式可以是XML（5系），也可能是JSON（6系）
    先通过fastJson实现了JSON方式的数据解析
    数据格式为6系统一定义的格式：ROOT下面包含HEADER、BODY
    BODY下面的TABLES为实际落地的数据同步对象，其他为操作基础信息，可能包含有BUSI_INFO业务工单
    TABLES下面有多个表的数据，而每个表可以有DATARECORDS，多条记录

具体格式例子：

    {
        "ROOT": {
            "HEADER": {
                "DB_ID": "EUR"
            },
            "BODY": {
                "OPR_INFO": {
                    "OP_CODE": "1060",
                    "OP_TIME": "20170117073802",
                    "LOGIN_NO": "test001",
                    "ACTION_ID": "13620",
                    "ORDER_LINE_ID": "L17011700000035"
                },
                "TABLES": [
                    {
                        "TABLENAME": "UR_SERVADDNUM_INFO",
                        "DATARECORDS": [
                            {
                                "COLS": {
                                    "COUNTRY_ID": "44",
                                    "OP_CODE": "1060",
                                    "OP_TIME": "20170117073639",
                                    "ID_NO": 100331000000007324,
                                    "STATE": "A",
                                    "LOGIN_ACCEPT": 10000000008905,
                                    "PHONE_NO": "7107300016",
                                    "ADD_NBR_TYPE": "01",
                                    "LOGIN_NO": "test001",
                                    "MASTER_SERV_ID": "1001",
                                    "STATE_DATE": "20170117073639",
                                    "FINISH_FLAG": "N",
                                    "ADD_SERVICE_NO": "7107300016"
                                },
                                "OP": "I"
                            },
                            {
                                "COLS": {
                                    "COUNTRY_ID": "852",
                                    "OP_CODE": "1060",
                                    "OP_TIME": "20170117073639",
                                    "ID_NO": 100331000000007324,
                                    "STATE": "A",
                                    "LOGIN_ACCEPT": 10000000008905,
                                    "PHONE_NO": "7107300016",
                                    "ADD_NBR_TYPE": "31",
                                    "LOGIN_NO": "test001",
                                    "MASTER_SERV_ID": "1001",
                                    "STATE_DATE": "20170117073639",
                                    "FINISH_FLAG": "N",
                                    "ADD_SERVICE_NO": "57602016"
                                },
                                "OP": "I"
                            }
                        ]
                    }
                ]
            }
        }
    }

具体类图实现如下：
![](https://github.com/eva233man/dataorder-parser/blob/master/data.png) 

 有了配置和解析后json数据对象，接下来是实际的解析并落地的过程
 
    因为落地的数据源可能存在多个，而且涉及事务需要对整个json对象在同一个数据源上的数据落地加事务管理
    所以创建DBPool，管理所有的数据源以及相应的JDBC操作对象和对应的事务管理对象
    解析器在初始化前必须先初始化DBPool，全局的，一个jvm启动加载一次
    解析器解析所有表的数据并落地，提取单表单数据源的解析落地过程进行封装，实现JDBCTemplate的实现类

类图如下：
![](https://github.com/eva233man/dataorder-parser/blob/master/parser.png) 

```java
    /**
     * 解析同步过来的数据工单，并且返回未解析的业务工单
     *
     * @param data 工单报文
     * @return busi_info json string
     */
    public static String parser(String data){
        final JsonData jsonData = new JsonData(data);
        final String dbId = jsonData.getDbId();

        final TransactionTemplate transactionTemplate = DBPool.getTransactionTemplate(dbId);
        final JdbcTemplate jdbcTemplate = DBPool.getJdbcTemplate(dbId);

        transactionTemplate.execute(new TransactionCallback() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                try {
                    for(JsonTable jsonTable : jsonData.getTables()) {
                        List configureDefinitions = configureFactory.getConfigureDefinitions(jsonTable.getTableName());
                        for(ConfigureDefinition configureDefinition : configureDefinitions){
                            TableExecuter tableExecuter = new JdbcTemplateTableExecuter(jdbcTemplate);
                            tableExecuter.execute(jsonTable, configureDefinition);
                        }
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                    status.setRollbackOnly();
                }

                return null;
            }
        });//处理成功，事务自动提交
        return jsonData.getBusiInfo().toJSONString();
    }
```

如何嵌入fortress框架：

    1.达成jar包，引入后台工程
    2.初始化DBPool，放到 AcctmgrWorker 的prepare 方法里面的spring配置加载之后
        DBPool.addDataSource(),使用这个方法加载所有的数据源，有几个执行几次，DataSource可以用getBean获取到
    3.初始化解析器，DataParser.init()
    4.在数据工单任务中使用，DataOrderTask 的 execute 方法里面使用：DataParser.parser(jsonstr),返回的业务工单继续处理

#待完善

    1.配置、数据部分已开发完成
    2.数据解析器
    3.待梳理其他特殊的业务场景，并实现
