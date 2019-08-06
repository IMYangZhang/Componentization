package com.example.lib_common.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lib_common.model.Student;

public class SqliteUtil {
    private static final String TAG = SqliteUtil.class.getName();

    private static SqliteUtil instance;
    private SqliteUtil(){}

    public static SqliteUtil getInstance(){
        if(instance==null){
            synchronized (SqliteUtil.class){
                if(instance == null){
                    instance = new SqliteUtil();
                }
            }
        }
        return instance;
    }
    /**
     *
     * @param database
     * @param tableName
     * @param values
     * @return -1 :失败
     */
    public long insert(SQLiteDatabase database, String tableName,ContentValues values){
        long result = database.insert(tableName,null,values);
        if(result==-1){
            Log.i(TAG, "insert: fail values="+values.toString());
        }
        return result;
    }

    public Student select(SQLiteDatabase database, String tableName){
        Student student = new Student();
        Cursor cursor = database.query(tableName, new String[]{"id","name","score"}, "id=?", new String[]{"1"}, null, null, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int score = cursor.getInt(2);
            student.setId(id);
            student.setName(name);
            student.setScore(score);
        }
        cursor.close();
        return student;
    }
}
