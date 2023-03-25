package com.example.project.Activity;

import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R;

public class MessageActivity extends AppCompatActivity {
    private Button mButton;
    private EditText mToEditText;
    private EditText mSubjectEditText;
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        mButton = findViewById(R.id.button);
        mToEditText = findViewById(R.id.toEditText);
        mSubjectEditText = findViewById(R.id.subjectEditText);
        mMessageEditText = findViewById(R.id.messageEditText);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to = mToEditText.getText().toString();
                String subject = mSubjectEditText.getText().toString();
                String message = mMessageEditText.getText().toString();

                String toastMessage = "To: " + to + "\nSubject: " + subject + "\nMessage: " + message;

                Toast.makeText(MessageActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}