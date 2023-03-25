package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.project.Adapter.MahasiswaAdapter;
import com.example.project.Models.Mahasiswa;
import com.example.project.R;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private List<Mahasiswa> mahasiswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);


        // inisialisasi data mahasiswa
        mahasiswaList = new ArrayList<>();
        mahasiswaList.add(new Mahasiswa("Jaya", "123456", "Teknik Informatika"));
        mahasiswaList.add(new Mahasiswa("Wijaya", "234567", "Sistem Informasi"));
        mahasiswaList.add(new Mahasiswa("Cici", "345678", "Teknik Elektro"));
        mahasiswaList.add(new Mahasiswa("Zettt", "345678", "Teknik Listrik"));
        mahasiswaList.add(new Mahasiswa("Jaya", "123456", "Teknik Informatika"));
        mahasiswaList.add(new Mahasiswa("Wijaya", "234567", "Sistem Informasi"));
        mahasiswaList.add(new Mahasiswa("Cici", "345678", "Teknik Elektro"));
        mahasiswaList.add(new Mahasiswa("Zettt", "345678", "Teknik Listrik"));
        mahasiswaList.add(new Mahasiswa("Jaya", "123456", "Teknik Informatika"));
        mahasiswaList.add(new Mahasiswa("Wijaya", "234567", "Sistem Informasi"));
        mahasiswaList.add(new Mahasiswa("Cici", "345678", "Teknik Elektro"));
        mahasiswaList.add(new Mahasiswa("Zettt", "345678", "Teknik Listrik"));
        mahasiswaList.add(new Mahasiswa("Jaya", "123456", "Teknik Informatika"));
        mahasiswaList.add(new Mahasiswa("Wijaya", "234567", "Sistem Informasi"));
        mahasiswaList.add(new Mahasiswa("Cici", "345678", "Teknik Elektro"));
        mahasiswaList.add(new Mahasiswa("Zettt", "345678", "Teknik Listrik"));
        mahasiswaList.add(new Mahasiswa("Jaya", "123456", "Teknik Informatika"));
        mahasiswaList.add(new Mahasiswa("Wijaya", "234567", "Sistem Informasi"));
        mahasiswaList.add(new Mahasiswa("Cici", "345678", "Teknik Elektro"));
        mahasiswaList.add(new Mahasiswa("Zettt", "345678", "Teknik Listrik"));

        // inisialisasi RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // inisialisasi adapter
        adapter = new MahasiswaAdapter(mahasiswaList);
        recyclerView.setAdapter(adapter);
    }
}