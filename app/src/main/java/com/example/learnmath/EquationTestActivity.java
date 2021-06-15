package com.example.learnmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnmath.equation.Equation;

public class EquationTestActivity extends AppCompatActivity {
    public static final String INTENT_EQUATION = "EquationTestActivityEquation";

    private Button buttonCheckEquation;
    private EditText editTextNumberPassed;
    private TextView textViewErrorMessage;
    private TextView textViewEquation;
    private TextView textViewResult;
    private Equation equation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation_test);


        buttonCheckEquation = findViewById(R.id.buttonCheckEquation);
        editTextNumberPassed = findViewById(R.id.editTextNumberPassed);
        textViewErrorMessage = findViewById(R.id.textViewErrorMessage);
        textViewEquation = findViewById(R.id.textViewEquation);
        textViewResult = findViewById(R.id.textViewResult);

        Intent intent = getIntent();
        equation = (Equation) intent.getSerializableExtra(INTENT_EQUATION);

        textViewEquation.setText(equation.toString());


        buttonCheckEquation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passedNumber = editTextNumberPassed.getText().toString();
                if (passedNumber.isEmpty()) {
                    textViewErrorMessage.setVisibility(View.VISIBLE);
                    return;
                }

                textViewErrorMessage.setVisibility(View.INVISIBLE);

                int number = Integer.parseInt(passedNumber);


                equation.makeGuess(number);

                textViewResult.setText(equation.getResult());

                if (equation.isCorrect()) {
                    textViewResult.setTextColor(Color.GREEN);
                }
                else {
                    textViewResult.setTextColor(Color.RED);
                }

                textViewResult.setVisibility(View.VISIBLE);
            }
        });
    }
}
