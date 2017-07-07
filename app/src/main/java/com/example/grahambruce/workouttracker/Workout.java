package com.example.grahambruce.workouttracker;

/**
 * Created by grahambruce on 07/07/2017.
 */

public class Workout {

    private int image;
    private String name;
    private String description;

    public Workout(int image, String name, String description){
        this.image = image;
        this.name = name;
        this.description = description;
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
}
