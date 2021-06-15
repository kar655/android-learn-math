package com.example.learnmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnmath.equation.Equation;
import com.example.learnmath.equation.EquationGenerator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button buttonTakeTest;
    private ArrayList<Equation> equations;
    private static final int TESTS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonTakeTest = findViewById(R.id.buttonTakeTest);

        buttonTakeTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EquationTestActivity.class);

                equations = EquationGenerator.generateEquations(TESTS);

                intent.putExtra(EquationTestActivity.INTENT_EQUATION, equations);
                startActivity(intent);
            }
        });
    }
}
