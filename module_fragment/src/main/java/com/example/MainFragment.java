package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.module_fragment.EmptyFragment;
import com.example.module_fragment.R;
import com.example.module_fragment.ZhiHuFragment;

import java.util.ArrayList;
import java.util.EnumMap;

public class MainFragment extends AppCompatActivity {

    private static final String TAG = "MainFragment";
    private ArrayList<Fragment>  fragments;

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_module_fragment);
        initFragment();
        Log.i(TAG, "onCreate: ");
    }

    private void initFragment(){
        fragments = new ArrayList<>();
        fragments.add(new EmptyFragment());
        fragments.add(new ZhiHuFragment());
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        for(Fragment fragment:fragments){
            fragmentTransaction.add(R.id.content_fragment,fragment,String.valueOf(fragments.indexOf(fragment))).hide(fragment);
        }
        // 显示第一个fragment
        fragmentTransaction.show(fragments.get(0));
        fragmentTransaction.commit();
    }



    public void replaceFragment(Fragment old,int indexFragment) {
        if (old.isAdded()) {
            getSupportFragmentManager().beginTransaction().hide(old).show(fragments.get(indexFragment)).commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}
