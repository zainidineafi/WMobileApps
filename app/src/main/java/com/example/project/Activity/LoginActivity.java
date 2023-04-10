package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.MainActivity;
import com.example.project.helper.SessionManager;
import com.example.project.R;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sessionManager = new SessionManager(getApplicationContext());

        if (sessionManager.isLoggedIn() == true) {
            // User sudah login, redirect ke MainActivity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Tutup activity login agar tidak bisa kembali ke halaman login setelah login berhasil
        } else {
            // User belum login, tampilkan halaman login
            setContentView(R.layout.activity_login);

            editTextEmail = findViewById(R.id.editTextEmail);
            editTextPassword = findViewById(R.id.editTextPassword);
            buttonLogin = findViewById(R.id.buttonLogin);

            // Set click listener for login button
            buttonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = editTextEmail.getText().toString();
                    String password = editTextPassword.getText().toString();

                    // Cek apakah username dan password kosong
                    if (email.trim().isEmpty() || password.trim().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    } else {
                        // Ambil data login user dari Shared Preferences
                        HashMap<String, String> userDetails = sessionManager.getUserDetails();
                        String storedEmail = userDetails.get(SessionManager.KEY_EMAIL);
                        String storedPassword = userDetails.get(SessionManager.KEY_PASSWORD);

                        // Bandingkan email dan password yang diinput dengan data login yang tersimpan
                        if (email.equals(storedEmail) && password.equals(storedPassword)) {
                            // Email dan password benar, redirect ke MainActivity
                            sessionManager.createLoginSession(email, password);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish(); // Tutup activity login agar tidak bisa kembali ke halaman login setelah login berhasil
                        } else {
                            // Email atau password salah, tampilkan pesan error
                            Toast.makeText(getApplicationContext(), "Email atau password salah!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
    }

    public void goToRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
