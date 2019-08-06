package com.example.module_main;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lib_common.sqlite.SqliteManager;
import com.example.lib_common.sqlite.SqliteUtil;
import com.example.lib_common.sqlite.StudentDataProvide;

public class MainLibraryActivity extends AppCompatActivity {
    private Button btnTest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_library_activity);
        btnTest = findViewById(R.id.main_btn_test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues kv = StudentDataProvide.getInstance().getContentValues(2,"yang",100);
                SQLiteDatabase sqLiteDatabase  = SqliteManager.getInstance().getWriteDatabaseStu();
                SqliteUtil.getInstance().insert(sqLiteDatabase,SqliteManager.TABLE_NAME_STU,kv);
                SqliteUtil.getInstance().select(sqLiteDatabase,SqliteManager.TABLE_NAME_STU);
                sqLiteDatabase.close();
            }
        });
    }
}
