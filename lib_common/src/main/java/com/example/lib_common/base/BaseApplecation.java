package com.example.lib_common.base;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

/**
 *
 */
public class BaseApplecation extends Application {

    @SuppressLint("StaticFieldLeak")
    protected static Context mContext;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // 突破65535限制
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initUM();
    }

    public static Context getmContext() {
        return mContext;
    }

    /**
     * 友盟第三方初始化
     */
    private void initUM(){
        UMConfigure.init(mContext,"5d4c2978570df31318000a99","channel2",UMConfigure.DEVICE_TYPE_PHONE,null); // 初始化友盟统计
        UMConfigure.setLogEnabled(true);  //设置组件化的Log开关
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.LEGACY_AUTO); // 设置模式集成方式为auto
//        MobclickAgent.onProfileSignIn("test");// 用户注册
    }
}
