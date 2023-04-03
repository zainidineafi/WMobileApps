package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project.Activity.DashboardActivity;
import com.example.project.Activity.DatePickerActivity;
import com.example.project.Activity.IntentActivity;
import com.example.project.Activity.ListCountryActivity;
import com.example.project.Activity.LoginActivity;
import com.example.project.Activity.MahasiswaActivity;
import com.example.project.Activity.RegisterActivity;
import com.example.project.Activity.DatePickerActivity;
import com.example.project.Activity.MessageActivity;
import com.example.project.Activity.CameraActivity;
import com.example.project.Activity.CRUDSQLActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnDashboard, btnIntent, btnListCountry, btnLogin, btnMahasiswa, btnRegister, btnDatePicker, btnMessage, btnKamera, btnCrud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDashboard = findViewById(R.id.btnDashboard);
        btnIntent = findViewById(R.id.btnIntent);
        btnListCountry = findViewById(R.id.btnListCountry);
        btnLogin = findViewById(R.id.btnLogin);
        btnMahasiswa = findViewById(R.id.btnMahasiswa);
        btnRegister = findViewById(R.id.btnRegister);
        btnDatePicker = findViewById(R.id.btnDatePicker);
        btnMessage = findViewById(R.id.btnMessage);
        btnKamera = findViewById(R.id.btnKamera);
        btnCrud = findViewById(R.id.btnCrud);



        btnDashboard.setOnClickListener(this);
        btnIntent.setOnClickListener(this);
        btnListCountry.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnMahasiswa.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        btnDatePicker.setOnClickListener(this);
        btnMessage.setOnClickListener(this);
        btnKamera.setOnClickListener(this);
        btnCrud.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnDashboard:
                intent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent);
                break;
            case R.id.btnIntent:
                intent = new Intent(MainActivity.this, IntentActivity.class);
                startActivity(intent);
                break;
            case R.id.btnListCountry:
                intent = new Intent(MainActivity.this, ListCountryActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLogin:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMahasiswa:
                intent = new Intent(MainActivity.this, MahasiswaActivity.class);
                startActivity(intent);
                break;
            case R.id.btnRegister:
                intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btnDatePicker:
                intent = new Intent(MainActivity.this, DatePickerActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMessage:
                intent = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(intent);
                break;
            case R.id.btnKamera:
                intent = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intent);
                break;
            case R.id.btnCrud:
                intent = new Intent(MainActivity.this, CRUDSQLActivity.class);
                startActivity(intent);
                break;
        }
    }
}
