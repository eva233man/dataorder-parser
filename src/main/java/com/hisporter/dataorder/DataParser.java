package com.hisporter.dataorder;

import com.hisporter.dataorder.data.JsonData;
import com.hisporter.dataorder.config.ConfigureDbFactory;
import com.hisporter.dataorder.config.ConfigureDefinition;
import com.hisporter.dataorder.config.ConfigureFactory;
import com.hisporter.dataorder.data.JsonTable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * 数据同步解析器
 *
 * @author zhangjinpeng
 * @date 2017/10/21
 */
public class DataParser {

    private static ConfigureFactory configureFactory;

    /**
     * 初始化
     */
    public static void init(){
        createConfigure(DBPool.getDataSource());
    }

    private static void createConfigure(DataSource defaultDataSource) {
        configureFactory = new ConfigureDbFactory(defaultDataSource);
        configureFactory.register();//注册所有的配置信息
    }

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

        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                try {
                    for(JsonTable jsonTable : jsonData.getTables()) {
                        List<ConfigureDefinition> configureDefinitions = configureFactory.getConfigureDefinitions(jsonTable.getTableName());
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

}
