package com.samir.android_livedata_preferences.sp;

import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;

public abstract class SPLiveData<T> extends LiveData<T> {
    protected SharedPreferences sharedPrefs;
    protected String spKey;
    private T defValue;

    abstract T getValueFromPreferences(String key, T defValue);

    public SPLiveData(String spKey, T defValue) {
        this.sharedPrefs = PreferenceManager.getSharedPreferences();
        this.spKey = spKey;
        this.defValue = defValue;
    }


    @Override
    protected void onActive() {
        super.onActive();
        setValue(getValueFromPreferences(spKey, defValue));
        sharedPrefs.registerOnSharedPreferenceChangeListener(preferenceChangeListener);
    }

    @Override
    protected void onInactive() {
        sharedPrefs.unregisterOnSharedPreferenceChangeListener(preferenceChangeListener);
        super.onInactive();
    }


    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (SPLiveData.this.spKey.equals(key)) {
                setValue(getValueFromPreferences(key, defValue));
            }
        }
    };


    ////========================================================================


    public SPLiveData<String> getStringLiveData(String key, String defaultValue) {
        return new SPStringLiveData(key, defaultValue);
    }

    public SPLiveData<Boolean> getBooleanLiveData(String key, Boolean defaultValue) {
        return new SPBooleanLiveData(key, defaultValue);
    }

}
