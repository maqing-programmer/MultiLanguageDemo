package com.example.multilanguagedemo;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;

import java.util.Locale;


public class LanguageUtil {

    public static final void changeLanguage(Context context, String language, String country) {
        if (context == null || TextUtils.isEmpty(language)) {
            return;
        }
        Resources resources = context.getResources();
        Configuration config = resources.getConfiguration();
        config.locale = new Locale(language, country);
        resources.updateConfiguration(config, null);
        SPUtil.put(Constant.CURRENT_LANGUAGE, language);
        SPUtil.put(Constant.CURRENT_COUNTRY, country);
        SPUtil.put(Constant.IS_FOLLOW_SYSTEM, false);
    }

    public static final void followSystemLanguage(Context context) {
        Resources resources = context.getResources();
        Configuration config = resources.getConfiguration();
        Locale locale = Locale.getDefault();
        config.locale = locale;
        resources.updateConfiguration(config, null);
        SPUtil.put(Constant.IS_FOLLOW_SYSTEM, true);
    }

}
