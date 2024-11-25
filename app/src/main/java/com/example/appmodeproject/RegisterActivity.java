package com.example.appmodeproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {


    EditText et_user,et_pwd,et_cpwd;
    Button reg;
    TextView text1;
    private TextView textViewError;
    // private FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        et_user=findViewById(R.id.newuser);
        et_pwd=findViewById(R.id.newpwd);
        et_cpwd=findViewById(R.id.confirmpwd);
        reg=findViewById(R.id.register);
        text1=findViewById(R.id.activityR2);
        textViewError = findViewById(R.id.textViewError);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = et_user.getText().toString();
                String password = et_pwd.getText().toString();
                validatePasswords();

                // Save the registration details
                SharedPreferences sharedPreferences = getSharedPreferences("User Prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("phoneNumber", phoneNumber);
                editor.putString("password", password);
                editor.apply();

                Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                // Redirect to LoginActivity
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finish this activity
            }
        });

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void validatePasswords() {
        String password = et_pwd.getText().toString().trim();
        String confirmPassword = et_cpwd.getText().toString().trim();

        if (!password.equals(confirmPassword)) {
            textViewError.setText("Passwords do not match!");
            textViewError.setVisibility(View.VISIBLE);
        } else {
            textViewError.setVisibility(View.GONE);
            // Proceed with registration or next steps
        }
    }
}