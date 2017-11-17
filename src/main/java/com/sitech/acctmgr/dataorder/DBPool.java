package com.sitech.acctmgr.dataorder;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据源池操作
 *
 * @author zhangjinpeng
 * @date 2017/10/22
 */

public class DBPool {

    private static final Map<String, DataSource> DATA_SOURCES = new ConcurrentHashMap<>();
    private static final Map<String, JdbcTemplate> JDBC_TEMLATES = new ConcurrentHashMap<>();
    private static final Map<String, TransactionTemplate> TRANSACTION_TEMPLATES = new ConcurrentHashMap<>();
    private static String defaultDb;
    /**
     * 一般oracle数据源都是双实例，用于做全库同步使用
     */
    private static List<String> dbLabel1;
    private static List<String> dbLabel2;

    /**
     * 增加数据源
     * @param dbId 数据源标签
     * @param dataSource 数据源
     */
    public static void addDataSource(String dbId, DataSource dataSource){
        if(DATA_SOURCES.containsKey(dbId)){
            System.out.println("当前数据源池已经添加过该数据源！");
            return;
        }
        DATA_SOURCES.put(dbId, dataSource);
        PlatformTransactionManager txManager = new DataSourceTransactionManager(dataSource);
        TRANSACTION_TEMPLATES.put(dbId, new TransactionTemplate(txManager));//针对数据源绑定事务管理器
        JDBC_TEMLATES.put(dbId, new JdbcTemplate(dataSource));
        if(defaultDb == null){
            defaultDb = dbId;
        }
        if(dbId.length()==2 && dbId.charAt(1)=='1'){
            dbLabel1.add(dbId);
        }
        if(dbId.length()==2 && dbId.charAt(1)=='2'){
            dbLabel2.add(dbId);
        }
    }

    /**
     * 设置默认数据源
     * @param dbId 数据源标签
     */
    public static void setDefaultDb(String dbId){
        if(DATA_SOURCES.containsKey(dbId)) {
            defaultDb = dbId;
        }
        else {
            throw new IllegalArgumentException("当前数据源池没有该数据源，不能设置为默认数据源！");
        }
    }

    public static List<String> getDbLabel1() {
        return dbLabel1;
    }

    public static List<String> getDbLabel2() {
        return dbLabel2;
    }

    /**
     * 根据标签获取数据源
     * @param dbId 数据源标签
     * @return 数据源
     */
    public static DataSource getDataSource(String dbId){
        if(!DATA_SOURCES.containsKey(dbId)){
            throw new IllegalArgumentException("当前数据源池没有设置该数据源："+ dbId +"！");
        }
        return DATA_SOURCES.get(dbId);
    }

    /**
     * 获取默认数据源
     * @return 数据源
     */
    public static DataSource getDataSource(){
        if(defaultDb==null){
            throw new IllegalArgumentException("当前数据源池没有设置数据源！");
        }
        return DATA_SOURCES.get(defaultDb);
    }

    /**
     * 根据标签获取JdbcTemplate
     * @param dbId 数据源标签
     * @return
     */
    public static JdbcTemplate getJdbcTemplate(String dbId){
        if(!JDBC_TEMLATES.containsKey(dbId)){
            throw new IllegalArgumentException("当前数据源池没有设置该数据源："+ dbId +"！");
        }
        return JDBC_TEMLATES.get(dbId);
    }

    /**
     * 获取默认的JdbcTemplate
     * @return
     */
    public static JdbcTemplate getJdbcTemplate(){
        if(defaultDb==null){
            throw new IllegalArgumentException("当前数据源池没有设置数据源！");
        }
        return JDBC_TEMLATES.get(defaultDb);
    }


    /**
     * 根据标签获取TransactionTemplate
     * @param dbId 数据源标签
     * @return
     */
    public static TransactionTemplate getTransactionTemplate(String dbId){
        if(!TRANSACTION_TEMPLATES.containsKey(dbId)){
            throw new IllegalArgumentException("当前数据源池没有设置该数据源："+ dbId +"！");
        }
        return TRANSACTION_TEMPLATES.get(dbId);
    }

    /**
     * 获取默认的JdbcTemplate
     * @return
     */
    public static TransactionTemplate getTransactionTemplate(){
        if(defaultDb==null){
            throw new IllegalArgumentException("当前数据源池没有设置数据源！");
        }
        return TRANSACTION_TEMPLATES.get(defaultDb);
    }
}
