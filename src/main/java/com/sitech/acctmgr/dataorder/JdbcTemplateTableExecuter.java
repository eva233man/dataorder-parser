package com.sitech.acctmgr.dataorder;

import com.alibaba.fastjson.JSONObject;
import com.sitech.acctmgr.dataorder.config.ColumnConfigureDefinition;
import com.sitech.acctmgr.dataorder.config.ConfigureDefinition;
import com.sitech.acctmgr.dataorder.data.JsonRecord;
import com.sitech.acctmgr.dataorder.data.JsonTable;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用JdbcTemplate对单表数据解析加执行
 *
 * @author zhangjinpeng
 * @date 2017/10/22
 */

public class JdbcTemplateTableExecuter implements TableExecuter {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateTableExecuter(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 根据表数据和配置信息，解析加执行
     *
     * @param jsonTable 要执行的表
     * @param configureDefinition 配置数据
     */
    @Override
    public void execute(JsonTable jsonTable, ConfigureDefinition configureDefinition) throws SQLException {
        for(JsonRecord jsonRecord : jsonTable.getRecords()){
            executeRecord(jsonRecord, configureDefinition);
        }
    }

    private static final String DATA_OPER_TYPE_INSERT  = "I";  //INSERT
    private static final String DATA_OPER_TYPE_UPDATE  = "U";  //UPDATE
    private static final String DATA_OPER_TYPE_DELETE  = "D";  //DELETE
    private static final String DATA_OPER_TYPE_SPECIAL = "X"; //special operation

    /**
     * 根据配置数据及表一行记录解析成sql并在目标库执行
     *
     * @param jsonRecord 要执行的记录
     * @param configureDefinition 配置数据
     */
    private void executeRecord(JsonRecord jsonRecord, ConfigureDefinition configureDefinition) throws SQLException {
        String operation = jsonRecord.getOperation();
        switch (operation) {
            case DATA_OPER_TYPE_INSERT:
                executeInsertSql(jsonRecord.getColumns(), configureDefinition);
                break;
            case DATA_OPER_TYPE_UPDATE:
                executeUpdateSql(jsonRecord.getColumns(), configureDefinition);
                break;
            case DATA_OPER_TYPE_DELETE:
                executeDeleteSql(jsonRecord.getColumns(), configureDefinition);
                break;
            case DATA_OPER_TYPE_SPECIAL:
                executeSpecialSql(jsonRecord.getColumns(), configureDefinition);
                break;
            default: break;
        }


    }

    private void executeSpecialSql(final JSONObject columns, final ConfigureDefinition configureDefinition) {

    }

    private void executeDeleteSql(final JSONObject columns, final ConfigureDefinition configureDefinition) {

    }

    private void executeUpdateSql(final JSONObject columns, final ConfigureDefinition configureDefinition) {

    }

    /**
     * 按insert解析字段并拼接sql执行
     *
     * @param columns 字段信息
     * @param configureDefinition 配置信息
     */
    private void executeInsertSql(final JSONObject columns, final ConfigureDefinition configureDefinition) throws SQLException {
        StringBuilder destSqlBuilder = new StringBuilder();
        destSqlBuilder.append("INSERT INTO ").append(configureDefinition.getDestTable()).append("(");
        int i = 0;
        List<Object> columnValues = new ArrayList<>();
        List<Integer> columnTypes = new ArrayList<>();
        final StringBuilder values = new StringBuilder();
        for(String columnName : columns.keySet()){
            if(!configureDefinition.containsColumn(columnName)){
                continue;//如果没有该字段配置，则下一个
            }
            ColumnConfigureDefinition columnConfigure = configureDefinition.getCloumnConfigureDefinition(columnName);

            if(i>0){
                destSqlBuilder.append(",");
                values.append(",");
            }
            destSqlBuilder.append(columnName);
            values.append("?");

            columnValues.add(columns.get(columnName));
            columnTypes.add(convertType(columnConfigure.getDataType()));

            i++;
        }
        if(i==0){//如果一个字段都没有，那么不处理该表
            return;
        }
        destSqlBuilder.append(") VALUES (").append(values).append(")");

        int[] types = new int[columnTypes.size()];
        for(int t = 0;t<columnTypes.size();t++){
            types[t] = columnTypes.get(i);
        }
        int ret = this.jdbcTemplate.update(destSqlBuilder.toString(), columnValues.toArray(new Object[columnValues.size()]), types);
        if(ret<=0){
            throw new SQLException(destSqlBuilder.toString() + "没有插入成功！");
        }
    }

    /**
     * 类型转换
     * @param dataType
     * @return
     */
    private int convertType(DataType dataType) {
        int type = Types.VARCHAR;
        switch (dataType){
            case STRING:
                type = Types.VARCHAR;
                break;
            case INT:
                type = Types.NUMERIC;
                break;
            case LONG:
                type = Types.NUMERIC;
                break;
            case DATE:
                type = Types.DATE;
                break;
            case DOUBLE:
                type = Types.NUMERIC;
                break;
            case TIME:
                type = Types.TIME;
                break;
            case TIMESTAMP:
                type = Types.TIMESTAMP;
                break;
            default:break;
        }
        return type;
    }
}
