package com.diuly.letscode.exercicioparte2.util;

import android.content.SharedPreferences;

/**
 * Created by letscode on 18/11/2017.
 */

public class SharedPreferenceUtil {
    private SharedPreferences sharedPreferences;

    public SharedPreferenceUtil(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public String get(String key) {
        return sharedPreferences.getString(key, "");
    }

    public boolean hasValue(String key) {
        return sharedPreferences.contains(key);
    }

    public void save(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
}
