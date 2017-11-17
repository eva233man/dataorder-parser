package com.sitech.acctmgr.dataorder.config;

import com.sitech.acctmgr.dataorder.DataType;

/**
 * 字段级配置定义类
 * Created by zhangjinpeng on 2017/10/21.
 */

public class ColumnConfigureDefinition {
    /**
     * SOURCE_COLUMN
     */
    private String sourceColumn;
    /**
     * DEST_COLUMN
     */
    private String destColumn;
    /**
     * DATA_TYPE
     */
    private DataType dataType;
    /**
     * INDEX_FLAG
     */
    private boolean index;
    /**
     * DEAL_FLAG
     */
    private boolean deal;
    /**
     * DEAL_VALUE
     */
    private String value;
    /**
     * OPER_FLAG
     */
    private String operation;

    public String getSourceColumn() {
        return sourceColumn;
    }

    public void setSourceColumn(String sourceColumn) {
        this.sourceColumn = sourceColumn;
    }

    public String getDestColumn() {
        return destColumn;
    }

    public void setDestColumn(String destColumn) {
        this.destColumn = destColumn;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public boolean isIndex() {
        return index;
    }

    public void setIndex(boolean index) {
        this.index = index;
    }

    public boolean isDeal() {
        return deal;
    }

    public void setDeal(boolean deal) {
        this.deal = deal;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
