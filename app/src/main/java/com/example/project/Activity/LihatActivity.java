package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.project.Models.Orang;
import com.example.project.R;

public class LihatActivity extends AppCompatActivity {

    private TextView tvNama, tvAlamat, tvTelepon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        tvNama = findViewById(R.id.tv_nama);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvTelepon = findViewById(R.id.tv_telepon);

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", -1);
        String nama = intent.getStringExtra("NAMA");
        String alamat = intent.getStringExtra("ALAMAT");
        String telepon = intent.getStringExtra("TELEPON");

        Orang orang = new Orang(id, nama, alamat, telepon);

        tvNama.setText("Nama: " + orang.getNama());
        tvAlamat.setText("Alamat: " + orang.getAlamat());
        tvTelepon.setText("Telepon: " + orang.getTelepon());
    }
}
