package com.hisporter.dataorder.config;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 定义配置的持有者
 * Created by zhangjinpeng on 2017/10/21.
 */

public class ConfigureDefinitionHolder {

    /**
     * 原表
     */
    private String sourceTable;
    /**
     * 目标表配置
     */
    private List<ConfigureDefinition> configureDefinitions = new CopyOnWriteArrayList<>();

    public ConfigureDefinitionHolder(String sourceTable){
        this.sourceTable = sourceTable;
    }

    public String getSourceTable() {
        return sourceTable;
    }


    public void addConfigureDefinition(ConfigureDefinition configureDefinition){
        this.configureDefinitions.add(configureDefinition);
    }

    public List<ConfigureDefinition> getConfigureDefinitions() {
        return configureDefinitions;
    }
}
