package com.example.learnmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.learnmath.equation.Equation;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    public static final String INTENT_CORRECT_RESPONSES = "ResultActivityCorrect";
    public static final String INTENT_ALL_RESPONSES = "ResultActivityAll";
    public static final String INTENT_EQUATION = "ResultActivityEquation";


    private Button buttonPracticeMore;
    private Button buttonCheckResults;
    private TextView textViewScored;

    private ArrayList<Equation> equations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        buttonPracticeMore = findViewById(R.id.buttonPracticeMore);
        buttonCheckResults = findViewById(R.id.buttonCheckResults);
        textViewScored = findViewById(R.id.textViewScored);


        Intent intent = getIntent();

        int correctResponses = intent.getIntExtra(INTENT_CORRECT_RESPONSES, -1);
        int allResponses = intent.getIntExtra(INTENT_ALL_RESPONSES, -1);
        equations = (ArrayList<Equation>) intent.getSerializableExtra(INTENT_EQUATION);

        textViewScored.setText("You scored " + correctResponses + " out of " + allResponses);

        buttonPracticeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonCheckResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(ResultActivity.this, SummaryActivity.class);

                newIntent.putExtra(SummaryActivity.INTENT_EQUATION, equations);
                startActivity(newIntent);
            }
        });
    }
}
