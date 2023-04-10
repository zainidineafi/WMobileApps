package com.example.project.helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    // Nama file Shared Preferences
    public static final String PREF_NAME = "MyPrefs";
    // Key untuk menyimpan email
    public static final String KEY_EMAIL = "email";
    // Key untuk menyimpan password
    public static final String KEY_PASSWORD = "password";
    // Key untuk menyimpan nama
    public static final String KEY_NAME = "name";
    // Key untuk menyimpan alamat
    public static final String KEY_ADDRESS = "address";
    // Key untuk menyimpan nomor handphone
    public static final String KEY_PHONE_NUMBER = "phone_number";
    // Key untuk menyimpan status login
    public static final String KEY_IS_LOGGED_IN = "is_logged_in";

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;

    // Constructor
    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    // Method untuk menyimpan data login ke dalam Shared Preferences
    public void createLoginSession(String email, String password) {
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.apply();
    }

    // Method untuk memeriksa apakah user sudah login atau belum
    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    // Method untuk mengambil data user dari Shared Preferences
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<>();
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));
        return user;
    }

    // Method untuk logout user dan menghapus data dari Shared Preferences
    public void logoutUser() {
        editor.putBoolean(KEY_IS_LOGGED_IN, false);
        editor.apply();
    }

    // Method untuk menyimpan data register ke dalam Shared Preferences
    public void createRegisterSession(String email, String name, String password, String address, String phoneNumber) {
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_PASSWORD, password);
        editor.putString(KEY_ADDRESS, address);
        editor.putString(KEY_PHONE_NUMBER, phoneNumber);
        editor.apply();
    }

    // Method untuk mengambil data user register dari Shared Preferences
    public HashMap<String, String> getRegisterDetails() {
        HashMap<String, String> user = new HashMap<>();
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));
        user.put(KEY_ADDRESS, pref.getString(KEY_ADDRESS, null));
        user.put(KEY_PHONE_NUMBER, pref.getString(KEY_PHONE_NUMBER, null));
        return user;
    }
}
