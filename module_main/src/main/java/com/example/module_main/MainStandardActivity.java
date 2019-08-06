package com.example.module_main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainStandardActivity extends AppCompatActivity {
    private Button btnJump;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_standard);
        btnJump = findViewById(R.id.btn_jump_to_single);
        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainStandardActivity.this,MainSingleTaskActivity.class));
            }
        });
    }
}
