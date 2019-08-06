package com.example.lib_common.base;

import android.app.Application;
import android.content.Context;

/**
 *
 */
public class BaseApplecation extends Application {


    protected static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this.getBaseContext();
    }

    public static Context getmContext() {
        return mContext;
    }
}
