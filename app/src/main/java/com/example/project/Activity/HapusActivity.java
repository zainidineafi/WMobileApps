package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.project.helper.DatabaseHelper;
import com.example.project.Models.Orang;
import com.example.project.R;

public class HapusActivity extends AppCompatActivity {
    private DatabaseHelper db;
    private Orang orang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus);

        db = new DatabaseHelper(this);

        // Ambil data orang dari intent
        orang = getIntent().getParcelableExtra("orang");

        Button buttonHapus = findViewById(R.id.button_hapus);
        Button buttonBatal = findViewById(R.id.button_batal);

        // Implementasi button hapus
        buttonHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hapus data orang dari database
                int deletedRows = db.deleteOrang(orang);
                if (deletedRows > 0) {
                    Toast.makeText(HapusActivity.this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    finish();
                } else {
                    Toast.makeText(HapusActivity.this, "Terjadi kesalahan saat menghapus data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Implementasi button batal
        buttonBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
