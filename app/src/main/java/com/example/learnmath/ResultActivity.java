package com.example.learnmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    public static final String INTENT_CORRECT_RESPONSES = "ResultActivityCorrect";
    public static final String INTENT_ALL_RESPONSES = "ResultActivityAll";

    private Button buttonPracticeMore;
    private TextView textViewScored;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        buttonPracticeMore = findViewById(R.id.buttonPracticeMore);
        textViewScored = findViewById(R.id.textViewScored);


        Intent intent = getIntent();

        int correctResponses = intent.getIntExtra(INTENT_CORRECT_RESPONSES, -1);
        int allResponses = intent.getIntExtra(INTENT_ALL_RESPONSES, -1);

        textViewScored.setText("You scored " + correctResponses + " out of " + allResponses);

        buttonPracticeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
