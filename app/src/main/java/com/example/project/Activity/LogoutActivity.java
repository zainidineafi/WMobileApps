package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project.MainActivity;
import com.example.project.helper.SessionManager;
import com.example.project.R;

public class LogoutActivity extends AppCompatActivity {

    private Button buttonLogout;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        sessionManager = new SessionManager(getApplicationContext());

        buttonLogout = findViewById(R.id.buttonLogout);

        // Set click listener for logout button
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear session and redirect to MainActivity
                sessionManager.logoutUser();
                Intent intent = new Intent(LogoutActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Close current activity
            }
        });
    }
}
