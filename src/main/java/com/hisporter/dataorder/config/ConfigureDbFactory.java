package com.hisporter.dataorder.config;

import com.hisporter.dataorder.DataType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 配置信息通过数据方式注册的工厂
 *
 * @author zhangjinpeng
 * @date 2017/10/21
 */

public class ConfigureDbFactory extends AbstractConfigureFactory{

    private static final String DATAODR_DISTTAB = "SELECT distinct SOURCE_TABLE, DEST_TABLE, SYNC_FLAG, TRIGGER_FLAG FROM IN_CBTABLE_SYNC_RELATION ";
    private static final String DATAODR_DESTTAB = "SELECT SOURCE_COLUMN,DEST_COLUMN,DATA_TYPE,INDEX_FLAG,SYNC_FLAG,DEAL_FLAG,DEAL_VALUE,OPER_FLAG " +
                                                 " FROM IN_CBTABLE_SYNC_RELATION  WHERE SOURCE_TABLE= ? AND DEST_TABLE= ?";


    private static JdbcTemplate jdbcTemplate;
    private static TransactionTemplate transactionTemplate;

    public ConfigureDbFactory(DataSource dataSource){
        super();
        jdbcTemplate = new JdbcTemplate(dataSource);

        PlatformTransactionManager txManager = new DataSourceTransactionManager(dataSource);
        transactionTemplate = new TransactionTemplate(txManager);//针对数据源绑定事务管理器
    }

    /**
     * 根据数据库注册所有的配置
     */
    @Override
    public void register() {
        /**
         * 增加事务处理
         */
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                /**
                 * 根据配置表查询原表和目标表的对应关系
                 * 支持1对多
                 */
                final List<ConfigureDefinition> configureDefinitions = new ArrayList<>();
                jdbcTemplate.query(DATAODR_DISTTAB, new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet rs) throws SQLException {
                        ConfigureDefinition configureDefinition = new ConfigureDefinition();
                        configureDefinition.setSourceTable(rs.getString("SOURCE_TABLE"));
                        configureDefinition.setDestTable(rs.getString("DEST_TABLE"));
                        configureDefinition.setStatus(rs.getString("SYNC_FLAG"));
                        configureDefinition.setTrigger(rs.getString("TRIGGER_FLAG").equals(1));
                        configureDefinitions.add(configureDefinition);
                    }
                });
                /**
                 * 循环处理所有的对应关系
                 */
                for(ConfigureDefinition configureDefinition : configureDefinitions){
                    ConfigureDefinitionHolder holder = createConfigureDefinitionHolder(configureDefinition);
                    configureDefinitionHolderMap.put(configureDefinition.getSourceTable(), holder);
                }
                return null;
            }
        });

    }

    /**
     * 将1对1的原表和目标表的配置及字段配置生成，并放入缓存
     * @param configureDefinition 对应关系配置
     * @return
     */
    private ConfigureDefinitionHolder createConfigureDefinitionHolder(final ConfigureDefinition configureDefinition) {
        String sourceTable =  configureDefinition.getSourceTable();
        String destTable = configureDefinition.getDestTable();
        /**
         * 创建configureDefinition剩下的配置
         */
        jdbcTemplate.query(DATAODR_DESTTAB, new Object[]{sourceTable, destTable} , new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                ColumnConfigureDefinition columnConfigureDefinition = new ColumnConfigureDefinition();
                String sourceColumn = rs.getString("SOURCE_COLUMN");
                columnConfigureDefinition.setSourceColumn(sourceColumn);
                columnConfigureDefinition.setDestColumn(rs.getString("DEST_COLUMN"));
                DataType dataType = getDataType(rs.getString("DATA_TYPE"));
                columnConfigureDefinition.setDataType(dataType);
                columnConfigureDefinition.setIndex(rs.getString("INDEX_FLAG").equals("Y"));
                columnConfigureDefinition.setDeal(rs.getString("DEAL_FLAG").equals("1"));
                columnConfigureDefinition.setValue(rs.getString("DEAL_VALUE"));
                columnConfigureDefinition.setOperation(rs.getString("OPER_FLAG"));

                configureDefinition.setCloumnConfigureDefinition(sourceColumn, columnConfigureDefinition);
            }
        });

        ConfigureDefinitionHolder holder = new ConfigureDefinitionHolder(sourceTable);
        holder.addConfigureDefinition(configureDefinition);
        return holder;
    }

    private DataType getDataType(String dataType) {
        DataType dt = DataType.STRING;
        switch (dataType){
            case "0": dt = DataType.STRING; break;
            case "1": dt = DataType.LONG; break;
            case "2": dt = DataType.DATE; break;
            case "3": dt = DataType.INT; break;
            case "4": dt = DataType.DOUBLE; break;
            case "5": dt = DataType.TIMESTAMP; break;
            case "6": dt = DataType.TIME; break;
            default: break;
        }
        return dt;
    }

}
