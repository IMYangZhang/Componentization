package com.example.module_main.util;

public class CommonFun {
    /**
     * 休眠，单位毫秒
     * @param mills
     */
    public static void sleep(int mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
