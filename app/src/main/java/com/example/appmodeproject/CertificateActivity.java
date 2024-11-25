package com.example.appmodeproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CertificateActivity extends AppCompatActivity {

    LinearLayout p4,chat4,s4,c4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_certificate);

        p4=findViewById(R.id.profile4);
        chat4=findViewById(R.id.Chat4);
        s4=findViewById(R.id.Score4);
        c4=findViewById(R.id.Certificate4);

        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(CertificateActivity.this, ProfileActivity.class);
                startActivity(i1);
            }
        });

        chat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(CertificateActivity.this, ChatActivity.class);
                startActivity(i2);
            }
        });

        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(CertificateActivity.this, ScoreActivity.class);
                startActivity(i3);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(CertificateActivity.this, CertificateActivity.class);
                startActivity(i4);
            }
        });
    }
}