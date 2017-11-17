package com.sitech.acctmgr.dataorder.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认配置信息注册的工厂
 * Created by zhangjinpeng on 2017/10/21.
 */

abstract class AbstractConfigureFactory implements ConfigureFactory{

    protected final Map<String, ConfigureDefinitionHolder> configureDefinitionHolderMap = new ConcurrentHashMap<>();

    /**
     * 获取原表要同步的所有的目标表的配置
     */
    @Override
    public List<ConfigureDefinition> getConfigureDefinitions(String sourceTable) {
        return configureDefinitionHolderMap.get(sourceTable).getConfigureDefinitions();
    }

    /**
     * 注册一个配置
     *
     * @param configureDefinition 原表对应的目标表的配置
     */
    @Override
    public void register(ConfigureDefinition configureDefinition) {
        ConfigureDefinitionHolder holder;
        if(configureDefinitionHolderMap.containsKey(configureDefinition.getSourceTable())){
            holder = configureDefinitionHolderMap.get(configureDefinition.getSourceTable());
        }else {
            holder = new ConfigureDefinitionHolder(configureDefinition.getSourceTable());
        }
        holder.addConfigureDefinition(configureDefinition);
        configureDefinitionHolderMap.put(configureDefinition.getSourceTable(), holder);
    }

    @Override
    abstract public void register();
}
