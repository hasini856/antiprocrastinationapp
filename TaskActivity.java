package com.example.antiprocrastination;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class TaskActivity extends AppCompatActivity {

    TextView taskText;
    Button startTimerButton;
    String activityType;
    String[] academicTasks = {"Write a paragraph", "Solve a math problem", "Read a short article"};
    String[] funTasks = {"Stretch for 5 mins", "Draw a doodle", "Listen to a song"};
    String selectedTask;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        taskText = findViewById(R.id.taskText);
        startTimerButton = findViewById(R.id.startTimerButton);

        activityType = getIntent().getStringExtra("activityType");

        selectedTask = getRandomTask(activityType);
        taskText.setText(selectedTask);

        startTimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaskActivity.this, TimerActivity.class);
                intent.putExtra("task", selectedTask);
                intent.putExtra("activityType", activityType);
                startActivity(intent);
            }
        });
    }

    private String getRandomTask(String type) {
        Random rand = new Random();
        if (type.equalsIgnoreCase("Academic")) {
            return academicTasks[rand.nextInt(academicTasks.length)];
        } else {
            return funTasks[rand.nextInt(funTasks.length)];
        }
    }
}
