package com.example.springdemo.common;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfSystemConstants {
    private static final Logger logger = Logger.getLogger(ConfSystemConstants.class);
    private ConfSystemConstants(){

    }
    protected static Properties p = new Properties();
    protected static void init(String propertyFileName){
        InputStream in = null;
        InputStream fis = null;
        try {
            in = ConfSystemConstants.class.getResourceAsStream(propertyFileName);
            p.clear();
            if(in != null){
                p.load(in);
            }
        }catch (IOException e){
            logger.error("load "+ propertyFileName+"into Constants error");
        }finally {
            if(in != null){
                try {
                    in.close();
                }catch (IOException e){
                    logger.error("载入系统配置文件出错，文件路径"+propertyFileName,e);
                }
            }
            if(fis != null){
                try {
                    fis.close();
                }catch (IOException e){
                    logger.error("载入系统配置文件出错，文件路径"+propertyFileName,e);
                }
            }
        }
    }
    public static String getProperty(String key,String defaultValue){
        return p.getProperty(key,defaultValue);
    }
    public static int getLoginTime(){
        String accessTokenExpires = "86400";
        return Integer.valueOf(accessTokenExpires);
    }
    static {
        init("/config.properties");
    }

    public static final String TEST = getProperty("test","");
    public static final String REDISHOST = getProperty("redis.host","");
    public static final String REDISPORT = getProperty("redis.port","");
}
