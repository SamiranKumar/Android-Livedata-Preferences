package com.samir.android_livedata_preferences.sp1;

import android.content.Context;
import android.content.SharedPreferences;

import com.samir.android_livedata_preferences.MyApplication;


public class CacheDataUtil {
    private static SharedPreferences preferences;

    public static void initialize() {
        if (preferences == null) {
            preferences = MyApplication.getContext().getSharedPreferences("CACH_DATA_Local", Context.MODE_PRIVATE);
        }
    }

    //=================================================================================

    public static SharedPreferences getPreferences() {
        return preferences;
    }

    //=================================================================================




    public static boolean write(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public static boolean write(String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public static boolean write(String key, long value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    public static boolean writeInt(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public static String read(String key) {
        return preferences.getString(key, "");
    }

    public static int readInt(String key) {
        return preferences.getInt(key, 0);
    }

    public static long readLong(String key) {
        return preferences.getLong(key, 0);
    }

    public static boolean readBoolean(String key) {
        return preferences.getBoolean(key, false);
    }



}
