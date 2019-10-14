package com.samir.android_livedata_preferences;

import android.app.Application;
import android.content.Context;

import com.samir.android_livedata_preferences.sp1.CacheDataUtil;

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        CacheDataUtil.initialize();
    }

    public static Context getContext() {
        return context;
    }
}
