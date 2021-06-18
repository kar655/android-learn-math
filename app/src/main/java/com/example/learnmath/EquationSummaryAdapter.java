package com.example.learnmath;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnmath.equation.Equation;

import java.util.ArrayList;

public class EquationSummaryAdapter extends RecyclerView.Adapter<EquationSummaryAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Equation> equations = new ArrayList<>();


    public EquationSummaryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.summary_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textViewSummary.setText(equations.get(position).getSummaryString());

        holder.cardViewSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Chosen " + equations.get(position).toString());
                Toast.makeText(context, "Chosen " + equations.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return equations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewSummary;
        private CardView cardViewSummary;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewSummary = itemView.findViewById(R.id.textViewSummary);
            cardViewSummary = itemView.findViewById(R.id.CardViewSummary);
        }
    }

    public void setEquations(ArrayList<Equation> equations) {
        this.equations = equations;
        notifyDataSetChanged();
    }
}
