package com.samir.android_livedata_preferences.sp;

import android.content.Context;
import android.content.SharedPreferences;

import com.samir.android_livedata_preferences.MyApplication;

public class PreferenceManager {


    public static SharedPreferences getSharedPreferences() {
        return MyApplication.getContext().getSharedPreferences("APP_LOCAL_DATA", Context.MODE_PRIVATE);
    }


    public static void setSharedPreferences(String key, boolean value) {

        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(key, value);
        editor.apply();
        new SPBooleanLiveData(key, value);
    }


    public static void setSharedPreferences(String key, String value) {

        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(key, value);
        editor.apply();
        new SPStringLiveData(key, value);
    }

}
