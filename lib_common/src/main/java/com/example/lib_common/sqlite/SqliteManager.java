package com.example.lib_common.sqlite;

import android.database.sqlite.SQLiteDatabase;

import com.example.lib_common.base.BaseApplecation;

public class SqliteManager {
    public static final String TABLE_NAME_STU = "stu_db";
    public static final String TABLE_NAME_OTHER="other_db";
    private static final int STU_VERSION = 1;
    private static final int OTHER_VERSION = 1;
    private static final String CREATE_TABLE_STU = "create table "+TABLE_NAME_STU+"("
            +"id integer primary key autoincrement,"
            +"name varchar(20) not null,"
            +"score integer not null"
            +");";
    private static final String CREATE_TABLE_OTHER = "";
    private SqliteHelper sqliteHelper;
    private SQLiteDatabase database;
    private static volatile SqliteManager sqliteManager;
    private static Object obj = new Object();

    private SqliteManager(){

    }

    public static SqliteManager getInstance(){
        if(sqliteManager == null){
            synchronized (obj){
                if(sqliteManager == null){
                    sqliteManager = new SqliteManager();
                }
            }
        }
        return sqliteManager;
    }


    public SQLiteDatabase getReadDatabaseStu(){
        sqliteHelper = new SqliteHelper(BaseApplecation.getmContext(),TABLE_NAME_STU,null,STU_VERSION,null);
        sqliteHelper.setCreateTable(CREATE_TABLE_STU);
        database = sqliteHelper.getReadableDatabase();
        return database;
    }

    public SQLiteDatabase getWriteDatabaseStu(){
        sqliteHelper = new SqliteHelper(BaseApplecation.getmContext(),TABLE_NAME_STU,null,STU_VERSION,null);
        sqliteHelper.setCreateTable(CREATE_TABLE_STU);
        database = sqliteHelper.getWritableDatabase();
        return database;
    }

    public SQLiteDatabase getReadDatabaseOther(){
        sqliteHelper = new SqliteHelper(BaseApplecation.getmContext(),TABLE_NAME_OTHER,null,STU_VERSION,null);
        sqliteHelper.setCreateTable(CREATE_TABLE_OTHER);
        database = sqliteHelper.getReadableDatabase();
        return database;
    }

    public SQLiteDatabase getWriteDatabaseOther(){
        sqliteHelper = new SqliteHelper(BaseApplecation.getmContext(),TABLE_NAME_OTHER,null,STU_VERSION,null);
        sqliteHelper.setCreateTable(CREATE_TABLE_OTHER);
        database = sqliteHelper.getWritableDatabase();
        return database;
    }

//    public void getReadDatabaseStu(){
//        databaseStu = sqliteHelper.getReadableDatabase();
//    }
//    public void getReadDatabaseOther(){
//        databaseOther = sqliteHelper.getReadableDatabase();
//    }
//    public void getWriteDatabaseStu(){
//        databaseStu = sqliteHelper.getWritableDatabase();
//    }
//    public void getWriteDatabaseOther(){
//        databaseOther = sqliteHelper.getWritableDatabase();
//    }
}
