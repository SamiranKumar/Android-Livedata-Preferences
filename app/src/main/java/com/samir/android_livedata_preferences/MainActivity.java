package com.samir.android_livedata_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.samir.android_livedata_preferences.sp.PreferenceManager;
import com.samir.android_livedata_preferences.sp.SPBooleanLiveData;
import com.samir.android_livedata_preferences.sp.SPStringLiveData;
import com.samir.android_livedata_preferences.sp1.CacheLiveDataUtil;


public class MainActivity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tvValue);


      //  getLiveData1();


         getLiveData();


    }

    private void getLiveData1() {

        String key = "ABC";

        SPStringLiveData SPStringLiveData = new SPStringLiveData(key, "");
        SPBooleanLiveData sharedPreferenceLiveData = new SPBooleanLiveData(key, false);

        sharedPreferenceLiveData.getBooleanLiveData(key, false).observe(this, check -> {
            if (check) {
                // Log.d("LOG","MESSAGE:"+check);
            }
            textView.setText("" + check + "".toUpperCase());
            Log.d("LOG", "MESSAGE:" + check);
        });


        findViewById(R.id.tvTrue).setOnClickListener(view -> {
            boolean va = true;

            Log.d("LOG", "set Bool:" + va);
            PreferenceManager.setSharedPreferences(key, va);
        });


        findViewById(R.id.tvFalse).setOnClickListener(view -> {
            boolean va = false;

            Log.d("LOG", "set Bool:" + va);
            PreferenceManager.setSharedPreferences(key, va);
        });


    }

    private void getLiveData() {

        String key = "ABC";


        CacheLiveDataUtil.readBoolean(key).observe(this, check -> {
            if (check) {
                // Log.d("LOG","MESSAGE:"+check);
            }
            textView.setText("" + check + "".toUpperCase());
            Log.d("LOG", "MESSAGE:" + check);
        });


        findViewById(R.id.tvTrue).setOnClickListener(view -> {
            boolean va = true;

            Log.d("LOG", "set Bool:" + va);
            CacheLiveDataUtil.write(key, va);
        });


        findViewById(R.id.tvFalse).setOnClickListener(view -> {
            boolean va = false;

            Log.d("LOG", "set Bool:" + va);
            CacheLiveDataUtil.write(key, va);
        });

    }
}
