package com.example.grahambruce.workouttracker;

import java.util.ArrayList;

/**
 * Created by grahambruce on 11/07/2017.
 */

public class EmptyWorkout {

    private ArrayList<String> myPlannedWorkout;

    public EmptyWorkout() {
        myPlannedWorkout = new ArrayList<String>();

    }

    public ArrayList<String> getWorkoutList() {
        return myPlannedWorkout;
    }
}
