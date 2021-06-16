package com.example.learnmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnmath.equation.Equation;
import com.example.learnmath.equation.EquationDifficulty;
import com.example.learnmath.equation.EquationGenerator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button buttonTakeTestEasy;
    private Button buttonTakeTestMedium;
    private Button buttonTakeTestHard;
    private ArrayList<Equation> equations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonTakeTestEasy = findViewById(R.id.buttonTakeTestEasy);
        buttonTakeTestMedium = findViewById(R.id.buttonTakeTestMedium);
        buttonTakeTestHard = findViewById(R.id.buttonTakeTestHard);

        buttonTakeTestEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOnClick(EquationDifficulty.EASY);
            }
        });

        buttonTakeTestMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOnClick(EquationDifficulty.MEDIUM);
            }
        });

        buttonTakeTestHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOnClick(EquationDifficulty.HARD);
            }
        });
    }

    private void handleOnClick(EquationDifficulty difficulty) {
        Intent intent = new Intent(MainActivity.this, EquationTestActivity.class);

        equations = EquationGenerator.generateEquations(difficulty);

        intent.putExtra(EquationTestActivity.INTENT_EQUATION, equations);
        startActivity(intent);
    }
}
