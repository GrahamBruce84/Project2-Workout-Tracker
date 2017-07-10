package com.example.grahambruce.workouttracker;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by grahambruce on 10/07/2017.
 */

public class PlannerAdapter extends ArrayAdapter<Workout> {

    public PlannerAdapter(Context context, ArrayList<Workout> workouts){
        super(context, 0, workouts);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){
        // Check if the existing view is being reused, otherwise inflate the view
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.planner_item, parent, false);
        }

        Workout currentWorkout = getItem(position);
        TextView workoutTitle = (TextView)listItemView.findViewById(R.id.workout_title);
        workoutTitle.setText(currentWorkout.getName());

        listItemView.setTag(currentWorkout);

        return listItemView;
    }
}
