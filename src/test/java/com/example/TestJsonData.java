package com.example;

import com.hisporter.dataorder.data.JsonData;
import org.junit.Test;

/**
 * Created by zhangjinpeng on 2017/10/21.
 */

public class TestJsonData {

    @Test
    public void testJsonData(){
        JsonData jsonData = new JsonData("{\n" +
                "    \"ROOT\": {\n" +
                "        \"HEADER\": {\n" +
                "            \"DB_ID\": \"EUR\",\n" +
                "            \"TRACE_ID\": \"11*20170117073604*1060*test001*566232\",\n" +
                "            \"CHANNEL_ID\": \"11\",\n" +
                "            \"PARENT_CALL_ID\": \"387F7866EE4AC2DA0F00940F07C04104\",\n" +
                "            \"PROVINCE_ID\": \"EUR\",\n" +
                "            \"LANG\": \"en_US\",\n" +
                "            \"TENANT_ID\": \"EUR\"\n" +
                "        },\n" +
                "        \"BODY\": {\n" +
                "            \"OPR_INFO\": {\n" +
                "                \"OP_CODE\": \"1060\",\n" +
                "                \"OP_TIME\": \"20170117073802\",\n" +
                "                \"LOGIN_NO\": \"test001\",\n" +
                "                \"ACTION_ID\": \"13620\",\n" +
                "                \"ORDER_LINE_ID\": \"L17011700000035\"\n" +
                "            },\n" +
                "            \"TABLES\": [\n" +
                "                {\n" +
                "                    \"TABLENAME\": \"AC_CONTRACT_INFO\",\n" +
                "                    \"DATARECORDS\": [\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"CONTRACT_NAME\": \"++xfrBv7yku+6/zbun\",\n" +
                "                                \"GROUP_ID\": \"1208\",\n" +
                "                                \"CONTRACTATT_TYPE\": \"13\",\n" +
                "                                \"STATUS_TIME\": \"20170117073639\",\n" +
                "                                \"REPRESENT_PHONE\": \"\",\n" +
                "                                \"CONTRACT_NAME_ENCRYPT\": \"\",\n" +
                "                                \"ACCOUNT_LIMIT\": \"0\",\n" +
                "                                \"ACCOUNT_TYPE\": \"0\",\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"CUST_ID\": 100341000000002452,\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"CONTRACT_PASSWD\": \"5889231b3062a35clnt\",\n" +
                "                                \"PAY_CODE\": \"0\",\n" +
                "                                \"CONTRACT_NO\": 100381000000000846,\n" +
                "                                \"STATUS_CODE\": 1\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"TABLENAME\": \"CS_CONUSERREL_INFO\",\n" +
                "                    \"DATARECORDS\": [\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"RATE_FLAG\": \"N\",\n" +
                "                                \"REMARK\": \"\",\n" +
                "                                \"EFF_DATE\": \"20170117073639\",\n" +
                "                                \"BILL_ORDER\": 99999999,\n" +
                "                                \"SERV_ACCT_ID\": 1108,\n" +
                "                                \"CYCLE_TYPE\": \"0\",\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"EXP_DATE\": \"20500101000000\",\n" +
                "                                \"CHKOUT_PRI\": 0,\n" +
                "                                \"PAY_TYPE\": \"0\",\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"FINISH_FLAG\": \"Y\",\n" +
                "                                \"PAY_VALUE\": 0,\n" +
                "                                \"CONTRACT_NO\": 100381000000000846,\n" +
                "                                \"DATE_CYCLE\": 1\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"TABLENAME\": \"UR_SERVADDNUM_INFO\",\n" +
                "                    \"DATARECORDS\": [\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"COUNTRY_ID\": \"44\",\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"STATE\": \"A\",\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"PHONE_NO\": \"7107300016\",\n" +
                "                                \"ADD_NBR_TYPE\": \"01\",\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"MASTER_SERV_ID\": \"1001\",\n" +
                "                                \"STATE_DATE\": \"20170117073639\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"ADD_SERVICE_NO\": \"7107300016\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"COUNTRY_ID\": \"852\",\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"STATE\": \"A\",\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"PHONE_NO\": \"7107300016\",\n" +
                "                                \"ADD_NBR_TYPE\": \"31\",\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"MASTER_SERV_ID\": \"1001\",\n" +
                "                                \"STATE_DATE\": \"20170117073639\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"ADD_SERVICE_NO\": \"57602016\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"TABLENAME\": \"UR_USERIMSI_INFO\",\n" +
                "                    \"DATARECORDS\": [\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"IMSI_NO\": \"234103028410110\",\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"EXP_DATE\": \"20500101000000\",\n" +
                "                                \"PHONE_NO\": \"7107300016\",\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"EFF_DATE\": \"20170117073639\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"IMSI_NO\": \"234588550000056\",\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"EXP_DATE\": \"20500101000000\",\n" +
                "                                \"PHONE_NO\": \"7107300016\",\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"EFF_DATE\": \"20170117073639\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"IMSI_NO\": \"454070013800056\",\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"EXP_DATE\": \"20500101000000\",\n" +
                "                                \"PHONE_NO\": \"7107300016\",\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"EFF_DATE\": \"20170117073639\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"TABLENAME\": \"UR_USERPRCATTR_INFO\",\n" +
                "                    \"DATARECORDS\": [\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"SERV_ORDER_ID\": \"L17011700000035\",\n" +
                "                                \"PRODPRCINS_ID\": 10000000011839,\n" +
                "                                \"EFF_DATE\": \"20170117073625\",\n" +
                "                                \"GRP_NO\": \"0\",\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"ATTR_VALUE\": \"1\",\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"EXP_DATE\": \"20170417000000\",\n" +
                "                                \"ATTR_NO\": \"0\",\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"PROD_PRCID\": \"EUCAZ1000013\",\n" +
                "                                \"ATTR_ID\": \"EUB00002\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"SERV_ORDER_ID\": \"L17011700000035\",\n" +
                "                                \"PRODPRCINS_ID\": 10000000011839,\n" +
                "                                \"EFF_DATE\": \"20170117073625\",\n" +
                "                                \"GRP_NO\": \"0\",\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"ATTR_VALUE\": \"1\",\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"EXP_DATE\": \"20170417000000\",\n" +
                "                                \"ATTR_NO\": \"0\",\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"PROD_PRCID\": \"EUCAZ1000013\",\n" +
                "                                \"ATTR_ID\": \"EUB00004\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"SERV_ORDER_ID\": \"L17011700000035\",\n" +
                "                                \"PRODPRCINS_ID\": 10000000011839,\n" +
                "                                \"EFF_DATE\": \"20170117073625\",\n" +
                "                                \"GRP_NO\": \"0\",\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"ATTR_VALUE\": \"3\",\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"EXP_DATE\": \"20170417000000\",\n" +
                "                                \"ATTR_NO\": \"0\",\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"PROD_PRCID\": \"EUCAZ1000013\",\n" +
                "                                \"ATTR_ID\": \"EUB00007\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"TABLENAME\": \"UR_USERPRC_INFO\",\n" +
                "                    \"DATARECORDS\": [\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"STATE\": \"A\",\n" +
                "                                \"ORDER_DATE\": \"20170117073639\",\n" +
                "                                \"SERV_ORDER_ID\": \"L17011700000035\",\n" +
                "                                \"STATE_DATE\": \"20170117073639\",\n" +
                "                                \"REMARK\": \"\",\n" +
                "                                \"PRODPRCINS_ID\": 10000000011835,\n" +
                "                                \"CANCLE_SOURCE\": \"\",\n" +
                "                                \"GOODSINS_ID\": 1,\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"PRICING_ID\": 0,\n" +
                "                                \"EXP_DATE\": \"20170417000000\",\n" +
                "                                \"PROD_ID\": \"EUPAF0001\",\n" +
                "                                \"PROD_PRCID\": \"EUCAF0001\",\n" +
                "                                \"GROUP_ID\": 0,\n" +
                "                                \"RELPRCINS_ID\": 10000000011839,\n" +
                "                                \"PARPRC_ID\": \"EUCAZ1000013\",\n" +
                "                                \"DEVELOP_LOGIN\": \"\",\n" +
                "                                \"EFF_DATE\": \"20170117073625\",\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"PROD_MAIN_FLAG\": \"1\",\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"TEAM_ID\": 0,\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"DATA_OPSOURCE\": \"\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"ORDER_SOURCE\": \"\",\n" +
                "                                \"TRANPRCINS_ID\": 0,\n" +
                "                                \"ORDER_LOGINNO\": \"\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"STATE\": \"A\",\n" +
                "                                \"ORDER_DATE\": \"20170117073639\",\n" +
                "                                \"SERV_ORDER_ID\": \"L17011700000035\",\n" +
                "                                \"STATE_DATE\": \"20170117073639\",\n" +
                "                                \"REMARK\": \"\",\n" +
                "                                \"PRODPRCINS_ID\": 10000000011836,\n" +
                "                                \"CANCLE_SOURCE\": \"\",\n" +
                "                                \"GOODSINS_ID\": 1,\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"PRICING_ID\": 0,\n" +
                "                                \"EXP_DATE\": \"20170417000000\",\n" +
                "                                \"PROD_ID\": \"EUPAF0002\",\n" +
                "                                \"PROD_PRCID\": \"EUCAF0002\",\n" +
                "                                \"GROUP_ID\": 0,\n" +
                "                                \"RELPRCINS_ID\": 10000000011839,\n" +
                "                                \"PARPRC_ID\": \"EUCAZ1000013\",\n" +
                "                                \"DEVELOP_LOGIN\": \"\",\n" +
                "                                \"EFF_DATE\": \"20170117073625\",\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"PROD_MAIN_FLAG\": \"1\",\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"TEAM_ID\": 0,\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"DATA_OPSOURCE\": \"\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"ORDER_SOURCE\": \"\",\n" +
                "                                \"TRANPRCINS_ID\": 0,\n" +
                "                                \"ORDER_LOGINNO\": \"\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"STATE\": \"A\",\n" +
                "                                \"ORDER_DATE\": \"20170117073639\",\n" +
                "                                \"SERV_ORDER_ID\": \"L17011700000035\",\n" +
                "                                \"STATE_DATE\": \"20170117073639\",\n" +
                "                                \"REMARK\": \"\",\n" +
                "                                \"PRODPRCINS_ID\": 10000000011837,\n" +
                "                                \"CANCLE_SOURCE\": \"\",\n" +
                "                                \"GOODSINS_ID\": 1,\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"PRICING_ID\": 0,\n" +
                "                                \"EXP_DATE\": \"20170417000000\",\n" +
                "                                \"PROD_ID\": \"EUPAF0003\",\n" +
                "                                \"PROD_PRCID\": \"EUCAF0003\",\n" +
                "                                \"GROUP_ID\": 0,\n" +
                "                                \"RELPRCINS_ID\": 10000000011839,\n" +
                "                                \"PARPRC_ID\": \"EUCAZ1000013\",\n" +
                "                                \"DEVELOP_LOGIN\": \"\",\n" +
                "                                \"EFF_DATE\": \"20170117073625\",\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"PROD_MAIN_FLAG\": \"1\",\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"TEAM_ID\": 0,\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"DATA_OPSOURCE\": \"\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"ORDER_SOURCE\": \"\",\n" +
                "                                \"TRANPRCINS_ID\": 0,\n" +
                "                                \"ORDER_LOGINNO\": \"\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"STATE\": \"A\",\n" +
                "                                \"ORDER_DATE\": \"20170117073639\",\n" +
                "                                \"SERV_ORDER_ID\": \"L17011700000035\",\n" +
                "                                \"STATE_DATE\": \"20170117073639\",\n" +
                "                                \"REMARK\": \"\",\n" +
                "                                \"PRODPRCINS_ID\": 10000000011838,\n" +
                "                                \"CANCLE_SOURCE\": \"\",\n" +
                "                                \"GOODSINS_ID\": 1,\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"PRICING_ID\": 0,\n" +
                "                                \"EXP_DATE\": \"20170417000000\",\n" +
                "                                \"PROD_ID\": \"EUPAF0005\",\n" +
                "                                \"PROD_PRCID\": \"EUCAF0005\",\n" +
                "                                \"GROUP_ID\": 0,\n" +
                "                                \"RELPRCINS_ID\": 10000000011839,\n" +
                "                                \"PARPRC_ID\": \"EUCAZ1000013\",\n" +
                "                                \"DEVELOP_LOGIN\": \"\",\n" +
                "                                \"EFF_DATE\": \"20170117073625\",\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"PROD_MAIN_FLAG\": \"1\",\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"TEAM_ID\": 0,\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"DATA_OPSOURCE\": \"\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"ORDER_SOURCE\": \"\",\n" +
                "                                \"TRANPRCINS_ID\": 0,\n" +
                "                                \"ORDER_LOGINNO\": \"\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"STATE\": \"A\",\n" +
                "                                \"ORDER_DATE\": \"20170117073639\",\n" +
                "                                \"SERV_ORDER_ID\": \"L17011700000035\",\n" +
                "                                \"STATE_DATE\": \"20170117073639\",\n" +
                "                                \"REMARK\": \"\",\n" +
                "                                \"PRODPRCINS_ID\": 10000000011839,\n" +
                "                                \"CANCLE_SOURCE\": \"\",\n" +
                "                                \"GOODSINS_ID\": 1,\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"PRICING_ID\": 448600201,\n" +
                "                                \"EXP_DATE\": \"20170417000000\",\n" +
                "                                \"PROD_ID\": \"EUPAZ0005\",\n" +
                "                                \"PROD_PRCID\": \"EUCAZ1000013\",\n" +
                "                                \"GROUP_ID\": 0,\n" +
                "                                \"RELPRCINS_ID\": 0,\n" +
                "                                \"PARPRC_ID\": \"0\",\n" +
                "                                \"DEVELOP_LOGIN\": \"\",\n" +
                "                                \"EFF_DATE\": \"20170117073625\",\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"PROD_MAIN_FLAG\": \"0\",\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"TEAM_ID\": 0,\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"DATA_OPSOURCE\": \"\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"ORDER_SOURCE\": \"\",\n" +
                "                                \"TRANPRCINS_ID\": 0,\n" +
                "                                \"ORDER_LOGINNO\": \"\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"TABLENAME\": \"UR_USERSVCTRACE_INFO\",\n" +
                "                    \"DATARECORDS\": [\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"STATE\": \"A\",\n" +
                "                                \"SERV_ORDER_ID\": \"L17011700000035\",\n" +
                "                                \"STATE_DATE\": \"20170117073639\",\n" +
                "                                \"PRODPRCINS_ID\": 10000000011835,\n" +
                "                                \"EFF_DATE\": \"20170117073625\",\n" +
                "                                \"SVCINS_ID\": 10000000002417,\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"EXP_DATE\": \"20170417000000\",\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"SVC_TYPE\": \"O\",\n" +
                "                                \"SVC_ID\": \"EUTF0001\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"STATE\": \"A\",\n" +
                "                                \"SERV_ORDER_ID\": \"L17011700000035\",\n" +
                "                                \"STATE_DATE\": \"20170117073639\",\n" +
                "                                \"PRODPRCINS_ID\": 10000000011836,\n" +
                "                                \"EFF_DATE\": \"20170117073625\",\n" +
                "                                \"SVCINS_ID\": 10000000002418,\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"EXP_DATE\": \"20170417000000\",\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"SVC_TYPE\": \"O\",\n" +
                "                                \"SVC_ID\": \"EUTF0002\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"STATE\": \"A\",\n" +
                "                                \"SERV_ORDER_ID\": \"L17011700000035\",\n" +
                "                                \"STATE_DATE\": \"20170117073639\",\n" +
                "                                \"PRODPRCINS_ID\": 10000000011837,\n" +
                "                                \"EFF_DATE\": \"20170117073625\",\n" +
                "                                \"SVCINS_ID\": 10000000002419,\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"EXP_DATE\": \"20170417000000\",\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"SVC_TYPE\": \"O\",\n" +
                "                                \"SVC_ID\": \"EUTF0003\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"STATE\": \"A\",\n" +
                "                                \"SERV_ORDER_ID\": \"L17011700000035\",\n" +
                "                                \"STATE_DATE\": \"20170117073639\",\n" +
                "                                \"PRODPRCINS_ID\": 10000000011838,\n" +
                "                                \"EFF_DATE\": \"20170117073625\",\n" +
                "                                \"SVCINS_ID\": 10000000002420,\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"EXP_DATE\": \"20170417000000\",\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"SVC_TYPE\": \"O\",\n" +
                "                                \"SVC_ID\": \"EUTF0005\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"STATE\": \"A\",\n" +
                "                                \"SERV_ORDER_ID\": \"L17011700000035\",\n" +
                "                                \"STATE_DATE\": \"20170117073639\",\n" +
                "                                \"PRODPRCINS_ID\": 10000000011839,\n" +
                "                                \"EFF_DATE\": \"20170117073625\",\n" +
                "                                \"SVCINS_ID\": 10000000002421,\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"EXP_DATE\": \"20170417000000\",\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"SVC_TYPE\": \"M\",\n" +
                "                                \"SVC_ID\": \"EU000001\"\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"TABLENAME\": \"UR_USER_INFO\",\n" +
                "                    \"DATARECORDS\": [\n" +
                "                        {\n" +
                "                            \"COLS\": {\n" +
                "                                \"OP_CODE\": \"1060\",\n" +
                "                                \"BAK_FIELD\": \"0\",\n" +
                "                                \"CMD_RIGHT\": 0,\n" +
                "                                \"ACCESS_TYPE\": \"001\",\n" +
                "                                \"LOGIN_ACCEPT\": 10000000008905,\n" +
                "                                \"COMPLETED_DATE\": \"20170117073639\",\n" +
                "                                \"CREATE_LOGIN\": \"test001\",\n" +
                "                                \"PHONE_NO\": \"7107300016\",\n" +
                "                                \"CUST_ID\": 100341000000002452,\n" +
                "                                \"BILL_END_TIME\": \"20500101000000\",\n" +
                "                                \"FIRST_USEDATE\": \"20500101000000\",\n" +
                "                                \"MASTER_SERV_ID\": \"1001\",\n" +
                "                                \"BILL_START_TIME\": \"20170117073639\",\n" +
                "                                \"PHOTO_FLAG\": \"N\",\n" +
                "                                \"BILL_TYPE\": 12,\n" +
                "                                \"ASSURE_FLAG\": \"0\",\n" +
                "                                \"GROUP_ID\": \"1208\",\n" +
                "                                \"BRAND_CREATE_TYPE\": \"1\",\n" +
                "                                \"BILLING_CYCLE_TYPE_ID\": 0,\n" +
                "                                \"BAK_FIELD1\": \"\",\n" +
                "                                \"RENT_DATE\": \"20170117073639\",\n" +
                "                                \"GROUP_FLAG\": \"N\",\n" +
                "                                \"SERVICE_GROUP\": \"1208\",\n" +
                "                                \"ID_NO\": 100331000000007324,\n" +
                "                                \"OWNER_TYPE\": 1,\n" +
                "                                \"OP_TIME\": \"20170117073639\",\n" +
                "                                \"OWNED_CHNL_ID\": \"1208\",\n" +
                "                                \"EMP_ID\": \"\",\n" +
                "                                \"EMP_GROUP\": \"\",\n" +
                "                                \"OPEN_TIME\": \"20170117073639\",\n" +
                "                                \"STOP_RENT_DATE\": \"20500101000000\",\n" +
                "                                \"LOGIN_NO\": \"test001\",\n" +
                "                                \"FINISH_FLAG\": \"N\",\n" +
                "                                \"CREATE_DATE\": \"20170117073639\",\n" +
                "                                \"CONTRACT_NO\": 100381000000000846\n" +
                "                            },\n" +
                "                            \"OP\": \"I\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    }\n" +
                "}");

        System.out.println(jsonData.getDbId());
        System.out.println(jsonData.getOprInfo("OP_CODE"));
        System.out.println(jsonData.getTables().get(2).getTableName());
        System.out.println(jsonData.getTables().get(2).getRecords().get(0).getOperation());
        System.out.println(jsonData.getTables().get(2).getRecords().get(0).getColumns());

    }
}
