package com.example.multilanguagedemo;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import java.util.Locale;

public class LocalApplication extends Application {
    private static Application sApplication;
    private static final String TAG = "LocalApplication";

    public static final Application getInstance() {
        return sApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }


}
