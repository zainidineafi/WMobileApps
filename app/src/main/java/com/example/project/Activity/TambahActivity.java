package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.Models.Orang;
import com.example.project.helper.DatabaseHelper;
import com.example.project.R;

public class TambahActivity extends AppCompatActivity {

    private EditText editTextNama, editTextAlamat, editTextTelepon;
    private Button buttonTambah;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        editTextNama = findViewById(R.id.editTextNama);
        editTextAlamat = findViewById(R.id.editTextAlamat);
        editTextTelepon = findViewById(R.id.editTextTelepon);
        buttonTambah = findViewById(R.id.buttonTambah);

        databaseHelper = new DatabaseHelper(this);

        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = editTextNama.getText().toString();
                String alamat = editTextAlamat.getText().toString();
                String telepon = editTextTelepon.getText().toString();

                Orang orang = new Orang(0, nama, alamat, telepon);

                boolean success = databaseHelper.addOrang(orang);

                if (success) {
                    Toast.makeText(TambahActivity.this, "Orang berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(TambahActivity.this, "Gagal menambahkan orang", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
