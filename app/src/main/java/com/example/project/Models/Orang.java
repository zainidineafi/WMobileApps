package com.example.project.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Orang implements Parcelable {
    private int id;
    private String nama;
    private String alamat;
    private String telepon;

    public Orang() {
        // empty constructor
    }

    public Orang(int id, String nama, String alamat, String telepon) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    protected Orang(Parcel in) {
        id = in.readInt();
        nama = in.readString();
        alamat = in.readString();
        telepon = in.readString();
    }

    public static final Creator<Orang> CREATOR = new Creator<Orang>() {
        @Override
        public Orang createFromParcel(Parcel in) {
            return new Orang(in);
        }

        @Override
        public Orang[] newArray(int size) {
            return new Orang[size];
        }
    };

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nama);
        dest.writeString(alamat);
        dest.writeString(telepon);
    }
}
