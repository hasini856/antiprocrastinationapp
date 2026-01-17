package com.example.antiprocrastination;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {

    TextView timerTaskText, countdownText;
    Button completeButton;
    String activityType, task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timerTaskText = findViewById(R.id.timerTaskText);
        countdownText = findViewById(R.id.countdownText);
        completeButton = findViewById(R.id.completeButton);

        // Initially hide the complete button until timer finishes
        completeButton.setVisibility(Button.INVISIBLE);

        // RECEIVE TASK PROPERLY
        task = getIntent().getStringExtra("task");
        activityType = getIntent().getStringExtra("activityType");

        // DISPLAY THE CORRECT TASK
        if (task != null) {
            timerTaskText.setText("Task: " + task);
        } else {
            timerTaskText.setText("Task not received!");
        }

        // COMPLETE BUTTON CLICK
        completeButton.setOnClickListener(view -> {
            Intent intent = new Intent(TimerActivity.this, CompletionActivity.class);
            intent.putExtra("activityType", activityType);
            startActivity(intent);
            finish();
        });

        // START 5-MINUTE TIMER
        startTimer(5 * 60); // 5 minutes
    }

    private void startTimer(int seconds) {
        new CountDownTimer(seconds * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                int sec = (int) (millisUntilFinished / 1000);
                countdownText.setText(String.format("%02d:%02d", sec / 60, sec % 60));
            }

            public void onFinish() {
                countdownText.setText("00:00");
                completeButton.setVisibility(Button.VISIBLE);
            }
        }.start();
    }
}
