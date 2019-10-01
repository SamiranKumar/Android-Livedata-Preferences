package com.samir.android_livedata_preferences.sp;


public class SPBooleanLiveData extends SPLiveData<Boolean> {

    public SPBooleanLiveData(String key, Boolean defValue) {
        super(key, defValue);
    }

    @Override
    Boolean getValueFromPreferences(String key, Boolean defValue) {
        return sharedPrefs.getBoolean(key, defValue);
    }

}
