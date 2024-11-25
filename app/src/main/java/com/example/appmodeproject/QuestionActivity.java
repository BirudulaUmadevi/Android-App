package com.example.appmodeproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuestionActivity extends AppCompatActivity {

    private EditText answerEditText;
    private Button submitButton;
    private TextView timerTextView;
    private CountDownTimer countDownTimer;
    private boolean isTimerRunning;
    ImageView back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question);

        answerEditText = findViewById(R.id.answer_edit_text);
        submitButton = findViewById(R.id.submit_button);
        timerTextView = findViewById(R.id.timer_text_view);
        back=findViewById(R.id.back_page);

        startTimer();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the submission of the answer here
                String answer = answerEditText.getText().toString();
                Toast.makeText(QuestionActivity.this,"Successfully Completed",Toast.LENGTH_LONG).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(QuestionActivity.this, ProfileActivity.class);
                startActivity(i1);
            }
        });
    }

    private void startTimer() {
        isTimerRunning = true;
        countDownTimer = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTextView.setText("Seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timerTextView.setText("Time's up!");
                answerEditText.setEnabled(false); // Disable editing
                submitButton.setVisibility(View.VISIBLE); // Show submit button
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
