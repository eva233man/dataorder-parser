package com.hisporter.dataorder.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * json类型的数据同步对象实现
 *
 * @author zhangjinpeng
 * @date 2017/10/21
 */

public class JsonData extends Data {
    private static final String ROOT = "ROOT";
    private static final String HEADER = "HEADER";
    private static final String BODY = "BODY";
    private static final String OPR_INFO = "OPR_INFO";
    private static final String TABLES = "TABLES";
    private static final String DB_ID = "DB_ID";
    private static final String BUSI_INFO = "BUSI_INFO";

    private JSONObject header;
    private String dbId;
    private JSONObject oprInfo;
    private JSONObject busiInfo;
    private List<JsonTable> tables = new ArrayList<>();

    public JsonData(String data){
        super(data);
        JSONObject root = JSON.parseObject(data).getJSONObject(ROOT);
        this.header  = root.getJSONObject(HEADER);
        this.dbId = header.getString(DB_ID);

        JSONObject body  = root.getJSONObject(BODY);
        this.oprInfo  = body.getJSONObject(OPR_INFO);
        this.busiInfo = body.getJSONObject(BUSI_INFO);

        JSONArray tableArray  = body.getJSONArray(TABLES);
        for(Object table : tableArray){
            tables.add(JSON.parseObject(JSON.toJSONString(table),JsonTable.class));
        }
    }

    public String getHeaderInfo(String key){
        return this.header.getString(key);
    }
    public String getOprInfo(String key){
        return this.oprInfo.getString(key);
    }
    public JSONObject getBusiInfo(){
        return this.busiInfo;
    }

    public List<JsonTable> getTables() {
        return this.tables;
    }

    public String getDbId() {
        return this.dbId;
    }
}
