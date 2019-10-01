package com.samir.android_livedata_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.samir.android_livedata_preferences.sp.PreferenceManager;
import com.samir.android_livedata_preferences.sp.SPBooleanLiveData;
import com.samir.android_livedata_preferences.sp.SPStringLiveData;

public class MainActivity extends AppCompatActivity {
    SPBooleanLiveData sharedPreferenceLiveData;
    SPStringLiveData SPStringLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tvValue);

        String key = "ABC";

        SPStringLiveData = new SPStringLiveData(key,"");
        sharedPreferenceLiveData = new SPBooleanLiveData(key,false);

        sharedPreferenceLiveData.getBooleanLiveData(key, false).observe(this, check -> {
            if (check) {
               // Log.d("LOG","MESSAGE:"+check);
            }
            textView.setText(""+check+"".toUpperCase());
            Log.d("LOG","MESSAGE:"+check);
        });




        findViewById(R.id.tvTrue).setOnClickListener(view -> {
            boolean va =true;

            Log.d("LOG","set Bool:"+va);
            PreferenceManager.setSharedPreferences(key,va);
        });


        findViewById(R.id.tvFalse).setOnClickListener(view -> {
            boolean va =false;

            Log.d("LOG","set Bool:"+va);
            PreferenceManager.setSharedPreferences(key,va);
        });


    }
}
