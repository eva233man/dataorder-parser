package com.sitech.acctmgr.dataorder.config;

import java.util.List;

/**
 * 定义配置的工厂接口
 * Created by zhangjinpeng on 2017/10/21.
 */
public interface ConfigureFactory {

    /**
     * 获取原表要同步的所有的目标表的配置
     */
    List<ConfigureDefinition> getConfigureDefinitions(String sourceTable);

    /**
     * 注册一个配置
     * @param configureDefinition 原表对应的目标表的配置
     */
    void register(ConfigureDefinition configureDefinition);

    /**
     * 注册配置
     */
    void register();
}
