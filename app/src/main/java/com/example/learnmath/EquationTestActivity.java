package com.example.learnmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.learnmath.equation.Equation;

import java.util.ArrayList;

public class EquationTestActivity extends AppCompatActivity {
    public static final String INTENT_EQUATION = "EquationTestActivityEquation";

    private Button buttonCheckEquation;
    private EditText editTextNumberPassed;
    private TextView textViewErrorMessage;
    private TextView textViewEquationText;
    private TextView textViewResult;
    private TextView textViewCurrentEquation;
    private TextView textViewEquationOf;

    private ArrayList<Equation> equations;
    private Equation equation;
    private boolean afterResult = false;
    private int currentEquation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation_test);


        buttonCheckEquation = findViewById(R.id.buttonCheckEquation);
        editTextNumberPassed = findViewById(R.id.editTextNumberPassed);
        textViewErrorMessage = findViewById(R.id.textViewErrorMessage);
        textViewEquationText = findViewById(R.id.textViewEquationText);
        textViewResult = findViewById(R.id.textViewResult);
        textViewCurrentEquation = findViewById(R.id.textViewCurrentEquation);
        textViewEquationOf = findViewById(R.id.textViewEquationOf);


        Intent intent = getIntent();
        equations = (ArrayList<Equation>) intent.getSerializableExtra(INTENT_EQUATION);
        equation = equations.get(currentEquation);

        textViewEquationText.setText(equation.toString());
        textViewEquationOf.setText(String.valueOf(equations.size()));
        textViewCurrentEquation.setText(String.valueOf(currentEquation + 1));


        buttonCheckEquation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (afterResult) {
                    resetViews();
                    return;
                }

                String passedNumber = editTextNumberPassed.getText().toString();
                if (passedNumber.isEmpty()) {
                    textViewErrorMessage.setVisibility(View.VISIBLE);
                    return;
                }

                textViewErrorMessage.setVisibility(View.INVISIBLE);

                int number = Integer.parseInt(passedNumber);


                editTextNumberPassed.setText("");
                editTextNumberPassed.setVisibility(View.GONE);
                buttonCheckEquation.setText("NEXT");

                equation.makeGuess(number);

                textViewResult.setText(equation.getResult());

                if (equation.isCorrect()) {
                    textViewResult.setTextColor(Color.GREEN);
                } else {
                    textViewResult.setTextColor(Color.RED);
                }

                textViewResult.setVisibility(View.VISIBLE);
                afterResult = true;
            }
        });
    }

    private void resetViews() {
        buttonCheckEquation.setText("CHECK");
        editTextNumberPassed.setText("");
        textViewResult.setVisibility(View.INVISIBLE);
        editTextNumberPassed.setVisibility(View.VISIBLE);
        afterResult = false;
        currentEquation++;
        textViewCurrentEquation.setText(String.valueOf(currentEquation + 1));

        equation = equations.get(currentEquation);
        textViewEquationText.setText(equation.toString());
    }
}
