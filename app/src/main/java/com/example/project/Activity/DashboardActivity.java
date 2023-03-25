package com.example.project.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.project.Fragment.GuruFragment;
import com.example.project.Fragment.HomeFragment;
import com.example.project.Fragment.SiswaFragment;
import com.example.project.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_kepala_sekolah:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                        return true;
                    case R.id.menu_siswa:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SiswaFragment()).commit();
                        return true;
                    case R.id.menu_guru:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new GuruFragment()).commit();
                        return true;
                }
                return false;
            }
        });
    }
}

