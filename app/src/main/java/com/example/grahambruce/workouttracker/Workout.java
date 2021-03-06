package com.example.grahambruce.workouttracker;

import java.io.Serializable;

/**
 * Created by grahambruce on 07/07/2017.
 */

public class Workout implements Serializable{

    private String level;
    private int image;
    private String name;
    private String description;
    private int reps;
    private int sets;

    public Workout(String level, int image, String name, String description){
        this.level = level;
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public int getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }
}
