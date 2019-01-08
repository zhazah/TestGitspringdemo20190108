package com.example.springdemo.util;

import java.util.UUID;

/**
 * @author 薛昭辉
 */
public class UUIDUtil {
    /**
     * 封装JDK自带的UUID，通过random数字生成，中间无“-”分割
     * @return
     */
    public static String uuid(){
        return java.util.UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 生成40位的UUID
     * @return
     */
    public static String uuid40(){
        return java.util.UUID.randomUUID().toString().replaceAll("-","")+ UUID.randomUUID().toString().replaceAll("-","").substring(0,8);
    }
}
