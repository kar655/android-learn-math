package com.example.learnmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
    private int correctResponses = 0;

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
                if (passedNumber.isEmpty() || passedNumber.equals("-")) {
                    textViewErrorMessage.setVisibility(View.VISIBLE);
                    return;
                }

                textViewErrorMessage.setVisibility(View.INVISIBLE);

                int number = Integer.parseInt(passedNumber);


                editTextNumberPassed.setText("");
                editTextNumberPassed.setVisibility(View.GONE);
                buttonCheckEquation.setText("NEXT");
                ViewGroup.LayoutParams params = buttonCheckEquation.getLayoutParams();
                params.width = (int) getResources().getDimension(R.dimen.button);
                buttonCheckEquation.setLayoutParams(params);

                equation.makeGuess(number);

                textViewResult.setText(equation.getResult());

                if (equation.isCorrect()) {
                    textViewResult.setTextColor(Color.GREEN);
                    correctResponses++;
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
        ViewGroup.LayoutParams params = buttonCheckEquation.getLayoutParams();
        params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        buttonCheckEquation.setLayoutParams(params);

        editTextNumberPassed.setText("");
        textViewResult.setVisibility(View.INVISIBLE);
        editTextNumberPassed.setVisibility(View.VISIBLE);
        afterResult = false;
        currentEquation++;

        if (currentEquation == equations.size()) {
            // Call to new activity showing result
            Intent intent = new Intent(EquationTestActivity.this, ResultActivity.class);

            intent.putExtra(ResultActivity.INTENT_CORRECT_RESPONSES, correctResponses);
            intent.putExtra(ResultActivity.INTENT_ALL_RESPONSES, equations.size());
            intent.putExtra(ResultActivity.INTENT_EQUATION, equations);
            startActivity(intent);
            finish();
            return;
        }

        textViewCurrentEquation.setText(String.valueOf(currentEquation + 1));

        equation = equations.get(currentEquation);
        textViewEquationText.setText(equation.toString());
    }
}
