package com.example.multilanguagedemo;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/**
 * Created by licrynoob on 2016/guide_2/12 <br>
 * Copyright (C) 2016 <br>
 * Email:licrynoob@gmail.com <p>
 * SharedPreferences封装类
 */
public class SPUtil {
    /**
     * 存入数据
     *
     * @param key   键
     * @param value 值
     */
    public static void put(String key, Object value) {
        SharedPreferences.Editor editor = getSharePreferences().edit();
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else {
            editor.putString(key, value.toString());
        }
        editor.commit();
    }

    /**
     * 获取数据
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return Object value
     */
    public static Object get(String key, Object defaultValue) {
        if (defaultValue instanceof String) {
            return getSharePreferences().getString(key, (String) defaultValue);
        } else if (defaultValue instanceof Integer) {
            return getSharePreferences().getInt(key, (Integer) defaultValue);
        } else if (defaultValue instanceof Boolean) {
            return getSharePreferences().getBoolean(key, (Boolean) defaultValue);
        } else if (defaultValue instanceof Float) {
            return getSharePreferences().getFloat(key, (Float) defaultValue);
        } else if (defaultValue instanceof Long) {
            return getSharePreferences().getLong(key, (Long) defaultValue);
        }
        return null;
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param key 键
     */
    public static void remove(String key) {
        SharedPreferences.Editor editor = getSharePreferences().edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     * 清除所有数据
     */
    public static void clearAll() {
        SharedPreferences.Editor editor = getSharePreferences().edit();
        editor.clear();
        editor.commit();
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param key 键
     * @return true 存在
     */
    public static boolean contains(String key) {
        return getSharePreferences().contains(key);
    }

    /**
     * 返回所有的键值对
     *
     * @return All key & value
     */
    public static Map<String, ?> getAll() {
        return getSharePreferences().getAll();
    }

    /**
     * 获取 SharedPreferences
     *
     * @return SharedPreferences
     */
    public static SharedPreferences getSharePreferences() {
        return LocalApplication.getInstance().getSharedPreferences(Constant.SP_NAME, Context.MODE_PRIVATE);
    }

}
