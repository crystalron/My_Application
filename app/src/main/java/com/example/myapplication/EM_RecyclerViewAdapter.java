package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EM_RecyclerViewAdapter extends RecyclerView.Adapter<EM_RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<ExerciseModel>exerciseModels;
    public EM_RecyclerViewAdapter(Context context, ArrayList<ExerciseModel> exerciseModels){
        this.context = context;
        this.exerciseModels = exerciseModels;
    }
    @NonNull
    @Override
    public EM_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.exercise_item, parent, false);

        return new EM_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EM_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(exerciseModels.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return exerciseModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = textView.findViewById(R.id.Kolvo);
        }
    }
}
