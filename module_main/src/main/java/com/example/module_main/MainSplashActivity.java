package com.example.module_main;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.example.lib_common.base.BaseActivity;
import com.example.module_main.util.Common;
import com.example.module_main.util.CommonFun;
import com.example.module_main.widgets.TextViewColorAnimator;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainSplashActivity extends BaseActivity {
    private static final String TAG = MainSplashActivity.class.getSimpleName();
    private static final int BEGIN_LOGIN = 1;

    private TextViewColorAnimator tv_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setExitTransition(new Slide(Gravity.TOP));// 设置当前activity的退出动画
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_splash_activity);
        initViews();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "threadID: " + Thread.currentThread().getName());
                login();
            }
        }, 1000);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initViews() {
        tv_login = findViewById(R.id.tv_mainsplash_compon);
    }

    /**
     * 跳转登陆模块
     * 隐式跳转
     */
    private void login() {
        Intent intent = new Intent(Common.LOGIN_TRANSITION);
//        ActivityOptionsCompat 适用于多个view的情况
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainSplashActivity.this, tv_login,
                getString(R.string.main_login_transition_name));
        startActivity(intent, options.toBundle());
    }
}
