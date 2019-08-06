package com.example.lib_common.sqlite;

import android.content.ContentValues;

import com.example.lib_common.model.Student;

public class StudentDataProvide {
    private static StudentDataProvide instance;

    private StudentDataProvide(){}

    public static StudentDataProvide getInstance(){
        if(instance == null){
            synchronized (StudentDataProvide.class){
                if(instance == null){
                    instance = new StudentDataProvide();
                }
            }
        }
        return instance;
    }

    public ContentValues getContentValues(int id,String name,int score){
        ContentValues cv = new ContentValues();
        cv.put("id",id);
        cv.put("name",name);
        cv.put("score",score);
        return cv;
    }
}
