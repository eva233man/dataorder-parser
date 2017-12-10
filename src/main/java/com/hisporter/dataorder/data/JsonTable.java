package com.hisporter.dataorder.data;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by zhangjinpeng on 2017/10/21.
 */

public class JsonTable {
    @JSONField(name = "TABLENAME")
    private String tableName;
    @JSONField(name = "DATARECORDS")
    private List<JsonRecord> records;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<JsonRecord> getRecords() {
        return records;
    }

    public void setRecords(List<JsonRecord> records) {
        this.records = records;
    }
}
