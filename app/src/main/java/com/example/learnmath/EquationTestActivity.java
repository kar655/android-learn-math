package com.example.learnmath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EquationTestActivity extends AppCompatActivity {

    private Button buttonCheckEquation;
    private EditText editTextNumberPassed;
    private TextView textViewErrorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation_test);


        buttonCheckEquation = findViewById(R.id.buttonCheckEquation);
        editTextNumberPassed = findViewById(R.id.editTextNumberPassed);
        textViewErrorMessage = findViewById(R.id.textViewErrorMessage);

        buttonCheckEquation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passedNumber = editTextNumberPassed.getText().toString();
                if (passedNumber.isEmpty()) {
                    textViewErrorMessage.setVisibility(View.VISIBLE);
                    return;
                }

                textViewErrorMessage.setVisibility(View.GONE);

                int number = Integer.parseInt(passedNumber);
                Toast.makeText(EquationTestActivity.this, "Check pressed with number " + number, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
