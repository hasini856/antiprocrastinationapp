package com.example.antiprocrastination;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class CompletionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completion);

        String activityType = getIntent().getStringExtra("activityType");

        Button proceedButton = findViewById(R.id.proceedButton);
        proceedButton.setOnClickListener(view -> {
            Intent intent = new Intent(CompletionActivity.this, FeedbackActivity.class);
            intent.putExtra("activityType", activityType);
            startActivity(intent);
            finish();
        });
    }
}
