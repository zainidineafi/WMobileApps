package com.example.project.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.project.R;


public class RegisterActivity extends AppCompatActivity {
    private EditText editTextEmail, editTextName, editTextPassword, editTextAddress, editTextPhoneNumber;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        EditText editTextAddress = findViewById(R.id.editTextAddress);
        EditText editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);

        Button buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setTitle("Konfirmasi");
                String message = "Email: " + editTextEmail.getText().toString() + "\n"
                        + "Nama: " + editTextName.getText().toString() + "\n"
                        + "Password: " + editTextPassword.getText().toString() + "\n"
                        + "Alamat: " + editTextAddress.getText().toString() + "\n"
                        + "Nomor Handphone: " + editTextPhoneNumber.getText().toString();
                builder.setMessage(message);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(getApplicationContext(), IntentActivity.class);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //TODO: Aksi ketika button Cancel ditekan
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
