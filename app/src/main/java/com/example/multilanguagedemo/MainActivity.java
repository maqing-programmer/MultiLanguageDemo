package com.example.multilanguagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
        mContext = this;
        setLanguage();
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_switch_language)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LanguageUtil.changeLanguage(mContext,
                                "en",
                                ""
                        );
                        recreate();
                    }
                });
        findViewById(R.id.btn_follow_system)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LanguageUtil.followSystemLanguage(mContext);
                        recreate();
                    }
                });

        findViewById(R.id.btn_jump)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(mContext, SecondActivity.class));
                    }
                });
    }

    private void setLanguage() {
        boolean isFollowSystem = (boolean) SPUtil.get(Constant.IS_FOLLOW_SYSTEM, false);
        if (!isFollowSystem) {
            String currentCountry = (String) SPUtil.get(Constant.CURRENT_COUNTRY, "CN");
            String currentLanguage = (String) SPUtil.get(Constant.CURRENT_LANGUAGE, "zh");
            LanguageUtil.changeLanguage(MainActivity.this, currentLanguage, currentCountry);
            Log.e(TAG, "setLanguage: " + currentCountry + "," + currentLanguage);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }

}