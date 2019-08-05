package com.example.lib_common;

public class GetMessageUtil {
    private static volatile GetMessageUtil instance;
    private String name ;
    private String info ;

    private GetMessageUtil(){
        // init
        name= "yangyang";
        info = "goodMan";
    }

    private GetMessageUtil getInstance(){
        if(instance==null){
            synchronized (GetMessageUtil.class){
                if(instance == null){
                    instance = new GetMessageUtil();
                }
            }
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}
