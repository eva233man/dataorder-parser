package com.sitech.acctmgr.dataorder.config;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 定义配置的实际内容
 * Created by zhangjinpeng on 2017/10/21.
 */

public class ConfigureDefinition {
    /**
     * 原表
     */
    private String sourceTable;
    /**
     * 目标表名
     */
    private String destTable;
    /**
     * 是否是chg表
     */
    private boolean trigger = false;
    /**
     * 全库同步标志
     */
    private String status;
    /**
     * 原表与目标表对应的字段
     */
    private ConcurrentHashMap<String, ColumnConfigureDefinition> cloumnConfigureDefinitionMap = new ConcurrentHashMap<>();

    public String getDestTable() {
        return destTable;
    }

    public void setDestTable(String destTable) {
        this.destTable = destTable;
    }

    public boolean isTrigger() {
        return trigger;
    }

    public void setTrigger(boolean trigger) {
        this.trigger = trigger;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ColumnConfigureDefinition getCloumnConfigureDefinition(String cloumnName) {
        return cloumnConfigureDefinitionMap.get(cloumnName);
    }

    public void setCloumnConfigureDefinition(String cloumnName, ColumnConfigureDefinition columnConfigureDefinition) {
        this.cloumnConfigureDefinitionMap.put(cloumnName, columnConfigureDefinition);
    }

    public boolean containsColumn(String cloumnName){
        return cloumnConfigureDefinitionMap.containsKey(cloumnName);
    }

    public String getSourceTable() {
        return sourceTable;
    }

    public void setSourceTable(String sourceTable) {
        this.sourceTable = sourceTable;
    }
}
