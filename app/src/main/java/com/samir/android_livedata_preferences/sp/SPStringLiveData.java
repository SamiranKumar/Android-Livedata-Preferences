package com.samir.android_livedata_preferences.sp;


public class SPStringLiveData extends SPLiveData<String> {

    public SPStringLiveData(String key, String defValue) {
        super(key, defValue);
    }

    @Override
    String getValueFromPreferences(String key, String defValue) {
        return sharedPrefs.getString(key, defValue);
    }

}
