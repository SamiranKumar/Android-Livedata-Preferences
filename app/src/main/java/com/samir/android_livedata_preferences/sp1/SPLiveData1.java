package com.samir.android_livedata_preferences.sp1;

import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;

public abstract class SPLiveData1<T> extends LiveData<T> {
    protected String spKey;
    private T dataValue;

    abstract T getValueFromPreferences(String key, T defValue);



    public SPLiveData1(String spKey, T dataValue) {
        this.spKey = spKey;
        this.dataValue = dataValue;
    }


    @Override
    protected void onActive() {
        super.onActive();
        setValue(getValueFromPreferences(spKey, dataValue));
        CacheDataUtil.getPreferences().registerOnSharedPreferenceChangeListener(preferenceChangeListener);
    }

    @Override
    protected void onInactive() {
        CacheDataUtil.getPreferences().unregisterOnSharedPreferenceChangeListener(preferenceChangeListener);
        super.onInactive();
    }


    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (SPLiveData1.this.spKey.equals(key)) {
                setValue(getValueFromPreferences(key, dataValue));
            }
        }
    };


    ////========================================================================



}
