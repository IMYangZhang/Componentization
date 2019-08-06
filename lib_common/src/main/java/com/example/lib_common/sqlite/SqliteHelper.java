package com.example.lib_common.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqliteHelper extends SQLiteOpenHelper {
    private static final String TAG = SqliteHelper.class.getName();

    private String createTable;
    public SqliteHelper(@androidx.annotation.Nullable Context context, @androidx.annotation.Nullable String name, @androidx.annotation.Nullable SQLiteDatabase.CursorFactory factory, int version, @androidx.annotation.Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    /**
     * 用于创建数据库的方法
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        if(createTable.isEmpty() || createTable==""){
            throw new NullPointerException("createTable is null or ''");
        }
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "onUpgrade: "+"oldVersion :"+oldVersion+" newVersion "+newVersion);
    }

    /**
     * @param createTable
     */
    public void setCreateTable(String createTable){
        this.createTable = createTable;
    }
}
