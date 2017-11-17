package com.sitech.acctmgr.dataorder.data;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by zhangjinpeng on 2017/10/21.
 */

public class JsonRecord {
    /**
     * 字段的操作：I、D、U
     */
    @JSONField(name = "OP")
    private String operation;
    /**
     * 所有的字段
     */
    @JSONField(name = "COLS")
    private JSONObject columns;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public JSONObject getColumns() {
        return columns;
    }

    public void setColumns(JSONObject columns) {
        this.columns = columns;
    }
}
