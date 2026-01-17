package com.example.antiprocrastination;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText activityInput;
    Button startButton, aboutMeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityInput = findViewById(R.id.activityInput);
        startButton = findViewById(R.id.startButton);
        aboutMeButton = findViewById(R.id.aboutMeButton);

        // Start Task (go to TaskActivity)
        startButton.setOnClickListener(view -> {
            String activityType = activityInput.getText().toString().trim();

            Intent intent = new Intent(MainActivity.this, TaskActivity.class);
            intent.putExtra("activityType", activityType);
            startActivity(intent);
        });

        // About Me
        aboutMeButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }
}
