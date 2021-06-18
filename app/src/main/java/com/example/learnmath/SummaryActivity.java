package com.example.learnmath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnmath.equation.Equation;

import java.util.ArrayList;

public class SummaryActivity extends AppCompatActivity {
    public static final String INTENT_EQUATION = "SummaryActivityEquation";

    private Button buttonBack;
    private RecyclerView recyclerView;

    private ArrayList<Equation> equations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent intent = getIntent();
        equations = (ArrayList<Equation>) intent.getSerializableExtra(INTENT_EQUATION);

        recyclerView = findViewById(R.id.recyclerView);
        buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        EquationSummaryAdapter adapter = new EquationSummaryAdapter(SummaryActivity.this);
        adapter.setEquations(equations);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
