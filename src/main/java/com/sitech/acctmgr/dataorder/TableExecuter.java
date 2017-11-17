package com.sitech.acctmgr.dataorder;

import com.sitech.acctmgr.dataorder.config.ConfigureDefinition;
import com.sitech.acctmgr.dataorder.data.JsonTable;

/**
 * 单表数据解析加执行
 * Created by zhangjinpeng on 2017/10/22.
 */

public interface TableExecuter {
    /**
     * 根据表数据和配置信息，解析加执行
     *
     * @param jsonTable
     * @param configureDefinition
     */
    void execute(JsonTable jsonTable, ConfigureDefinition configureDefinition) throws Exception;
}
