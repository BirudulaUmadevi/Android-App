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

public class MainActivity extends AppCompatActivity {


    Button bt;
    EditText ed_user1,ed_pwd1;
    TextView tv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        bt=findViewById(R.id.btn1);
        ed_user1=findViewById(R.id.user1);
        ed_pwd1=findViewById(R.id.pwd1);
        tv=findViewById(R.id.activityL1);

       // loadSavedCredentials();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = ed_user1.getText().toString();
                String password = ed_pwd1.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("User Prefs", MODE_PRIVATE);
                String storedPhoneNumber = sharedPreferences.getString("phoneNumber ", "");
                String storedPassword = sharedPreferences.getString("password", "");

                if (phoneNumber.equals(storedPhoneNumber) && password.equals(storedPassword)) {
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(intent);
                    finish();
                } else if (phoneNumber.equals(storedPhoneNumber) || password.equals(storedPassword)) {
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(intent);
                    finish();
                }
               else {

                    Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();

                }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

   /* private void loadSavedCredentials() {
        SharedPreferences sharedPreferences = getSharedPreferences("User Prefs", MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("username", "");
        String savedPassword = sharedPreferences.getString("password", "");

        ed_user1.setText(savedUsername);
        ed_pwd1.setText(savedPassword);
    }

    */
 }