package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.helper.DatabaseHelper;
import com.example.project.Models.Orang;
import com.example.project.R;

public class UpdateActivity extends AppCompatActivity {

    private EditText editNama, editAlamat, editTelp;
    private Button btnUpdate;

    private DatabaseHelper db;
    private Orang orang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        // Inisialisasi komponen UI
        editNama = findViewById(R.id.edit_nama);
        editAlamat = findViewById(R.id.edit_alamat);
        editTelp = findViewById(R.id.edit_telepon);
        btnUpdate = findViewById(R.id.btn_update);

        // Ambil data dari intent dan inisialisasi database
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int id = extras.getInt("ID");
            String nama = extras.getString("NAMA");
            String alamat = extras.getString("ALAMAT");
            String telp = extras.getString("TELEPON");

            orang = new Orang(id, nama, alamat, telp);
        }
        db = new DatabaseHelper(this);

        // Set nilai awal pada komponen UI
        editNama.setText(orang.getNama());
        editAlamat.setText(orang.getAlamat());
        editTelp.setText(orang.getTelepon());

        // Tambahkan listener pada tombol Update
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil nilai dari komponen UI
                String nama = editNama.getText().toString().trim();
                String alamat = editAlamat.getText().toString().trim();
                String telp = editTelp.getText().toString().trim();

                // Validasi input
                if (nama.isEmpty() || alamat.isEmpty() || telp.isEmpty()) {
                    Toast.makeText(UpdateActivity.this, "Silakan lengkapi semua data", Toast.LENGTH_SHORT).show();
                } else {
                    // Update data pada database
                    orang.setNama(nama);
                    orang.setAlamat(alamat);
                    orang.setTelepon(telp);
                    boolean success = db.updateOrang(orang);

                    if (success) {
                        Toast.makeText(UpdateActivity.this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(UpdateActivity.this, "Terjadi kesalahan saat mengupdate data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
