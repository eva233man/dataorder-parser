package com.sitech.acctmgr.dataorder.data;

/**
 * 同步的数据
 * Created by zhangjinpeng on 2017/10/21.
 */

public abstract class Data {
    /**
     * 原始数据
     */
    private String data;

    public Data(String data){
        this.data = data;
    }

    public String getData() {
        return data;
    }

}
