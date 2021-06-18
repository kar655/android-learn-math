package com.example.learnmath;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnmath.equation.Equation;

import java.util.ArrayList;

public class EquationSummaryAdapter extends RecyclerView.Adapter<EquationSummaryAdapter.ViewHolder> {

    private ArrayList<Equation> equations = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.summary_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textViewSummary.setText(equations.get(position).getSummaryString());
    }

    @Override
    public int getItemCount() {
        return equations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewSummary;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewSummary = itemView.findViewById(R.id.textViewSummary);
        }
    }

    public void setEquations(ArrayList<Equation> equations) {
        this.equations = equations;
        notifyDataSetChanged();
    }
}
