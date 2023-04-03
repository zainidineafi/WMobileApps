package com.example.project.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.project.Models.Orang;


import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db_orang";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "table_orang";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAMA = "nama";
    private static final String COLUMN_ALAMAT = "alamat";
    private static final String COLUMN_TELEPON = "telepon";

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_NAMA + " TEXT, "
                    + COLUMN_ALAMAT + " TEXT, "
                    + COLUMN_TELEPON + " TEXT"
                    + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addOrang(Orang orang) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMA, orang.getNama());
        values.put(COLUMN_ALAMAT, orang.getAlamat());
        values.put(COLUMN_TELEPON, orang.getTelepon());

        long id = db.insert(TABLE_NAME, null, values);
        db.close();

        return id > 0;
    }


    public boolean updateOrang(Orang orang) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMA, orang.getNama());
        values.put(COLUMN_ALAMAT, orang.getAlamat());
        values.put(COLUMN_TELEPON, orang.getTelepon());

        int count = db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{String.valueOf(orang.getId())});
        db.close();

        return count > 0;
    }


    public int deleteOrang(Orang id) {
        SQLiteDatabase db = getWritableDatabase();
        int count = db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id.getId())});

        db.close();

        return count;
    }

    public ArrayList<Orang> getAllOrang() {
        ArrayList<Orang> orangList = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Orang orang = new Orang();
                int idIndex = cursor.getColumnIndex(COLUMN_ID);
                if (idIndex >= 0) {
                    orang.setId(cursor.getInt(idIndex));
                }
                int namaIndex = cursor.getColumnIndex(COLUMN_NAMA);
                if (namaIndex >= 0) {
                    orang.setNama(cursor.getString(namaIndex));
                }
                int alamatIndex = cursor.getColumnIndex(COLUMN_ALAMAT);
                if (alamatIndex >= 0) {
                    orang.setAlamat(cursor.getString(alamatIndex));
                }
                int teleponIndex = cursor.getColumnIndex(COLUMN_TELEPON);
                if (teleponIndex >= 0) {
                    orang.setTelepon(cursor.getString(teleponIndex));
                }
                orangList.add(orang);
            } while (cursor.moveToNext());
        }

        if (cursor != null) {
            cursor.close();
        }
        db.close();

        return orangList;
    }

}
