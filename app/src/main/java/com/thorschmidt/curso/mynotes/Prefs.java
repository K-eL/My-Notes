package com.thorschmidt.curso.mynotes;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {

    public static final String PREFS_FILENAME = "usrprefs";
    public static final String PREFS_KEY_NOTES = "notes";

    /**
     * Save a string value in the given key inside the user shared preferences file
     * @param c
     * @param key
     * @param value
     */
    public static void savePrefs(Context c, String key, String value) {
        SharedPreferences prefs = c.getSharedPreferences(PREFS_FILENAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key,value);
        editor.commit();
    }

    /**
     * Given a key, the method load and return a string value from the user shared preferences file
     * @param c
     * @param key
     * @return
     */
    public static String getPrefs(Context c, String key) {
        SharedPreferences prefs = c.getSharedPreferences(PREFS_FILENAME,Context.MODE_PRIVATE);

        return prefs.getString(key,"");
    }
}
