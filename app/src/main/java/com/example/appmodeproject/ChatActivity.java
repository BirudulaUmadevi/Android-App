package com.example.appmodeproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChatActivity extends AppCompatActivity {

    LinearLayout p2,chat2,s2,c2;
    ImageView img1;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat);

        p2=findViewById(R.id.profile2);
        chat2=findViewById(R.id.Chat2);
        s2=findViewById(R.id.Score2);
        c2=findViewById(R.id.Certificate2);
        img1=findViewById(R.id.Chatimage);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(ChatActivity.this,"Add Contacts to start",Toast.LENGTH_LONG).show();

            }
        });


        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(ChatActivity.this, ProfileActivity.class);
                startActivity(i1);
            }
        });

        chat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(ChatActivity.this, ChatActivity.class);
                startActivity(i2);
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(ChatActivity.this, ScoreActivity.class);
                startActivity(i3);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(ChatActivity.this, CertificateActivity.class);
                startActivity(i4);
            }
        });
    }
}