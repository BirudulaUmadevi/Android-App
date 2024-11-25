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

public class ScoreActivity extends AppCompatActivity {
    LinearLayout p3,chat3,s3,c3;
    ImageView img2;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);

        p3=findViewById(R.id.profile3);
        chat3=findViewById(R.id.Chat3);
        s3=findViewById(R.id.Score3);
        c3=findViewById(R.id.Certificate3);
        img2=findViewById(R.id.Scoreimage);

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ScoreActivity.this,"No Score are Mentioned",Toast.LENGTH_LONG).show();

            }
        });


        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(ScoreActivity.this, ProfileActivity.class);
                startActivity(i1);
            }
        });

        chat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(ScoreActivity.this, ChatActivity.class);
                startActivity(i2);
            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(ScoreActivity.this, ScoreActivity.class);
                startActivity(i3);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(ScoreActivity.this, CertificateActivity.class);
                startActivity(i4);
            }
        });
    }
}