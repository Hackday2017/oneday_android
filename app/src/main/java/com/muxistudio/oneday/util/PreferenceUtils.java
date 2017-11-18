package com.muxistudio.oneday.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.muxistudio.oneday.App;

/**
 * Created by fengminchao on 17/11/18
 */

public class PreferenceUtils {

    public static void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(App.getContext()).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getBoolean(String key) {
        return PreferenceManager.getDefaultSharedPreferences(App.getContext()).getBoolean(key, false);
    }

    public static boolean getBoolean(String key, boolean def) {
        return PreferenceManager.getDefaultSharedPreferences(App.getContext()).getBoolean(key, def);
    }

    public static void putString(String key, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(App.getContext()).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(String key) {
        return PreferenceManager.getDefaultSharedPreferences(App.getContext()).getString(key, "");
    }

    public static String getString(String key, String def) {
        return PreferenceManager.getDefaultSharedPreferences(App.getContext()).getString(key, def);
    }

    public static void putInt(String key, int value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(App.getContext()).edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getInt(String key) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(App.getContext());
        return sp.getInt(key, -1);
    }

    public static int getInt(String key, int def) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(App.getContext());
        return sp.getInt(key, def);
    }

    public static void putFloat(String key, float value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(App.getContext()).edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public static float getFloat(String key) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(App.getContext());
        return sp.getFloat(key, -1);
    }

    public static long getLong(String key) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(App.getContext());
        return sp.getLong(key, -1);
    }

    public static void putLong(String key, long value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(App.getContext()).edit();
        editor.putLong(key, value);
        editor.apply();
    }


}
