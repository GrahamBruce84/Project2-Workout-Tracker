package com.example.grahambruce.workouttracker;

import java.util.ArrayList;

/**
 * Created by grahambruce on 08/07/2017.
 */

public class WorkoutList {

    private static ArrayList<Workout> workoutList;

    public WorkoutList() {
        workoutList = new ArrayList<Workout>();
        workoutList.add(new Workout("Novice", R.drawable.pushups, "Push ups", "Lie on the floor face down with your feet together and place hands underneath your shoulders but slightly further apart. Push off the ground until your arms are straight. Your body should be one straight line from head to toe. Slowly lower your body towards the ground until your chest is grazing the floor then push your body off the ground until your arms are straight again. Repeat until your set repetitions are complete."));
        workoutList.add(new Workout("Novice", R.drawable.crunches, "Crunches", "Lie on the floor face up and knees bent at 45 degrees feet planted firmly on the floor. Place your hands on your hips. Engage your core muscles and lift your shoulders off the floor sliding your hands up your legs until the tips of your fingers curl over your knee. Lower your body back to the ground. Repeat until your set repetitions are complete. "));
        workoutList.add(new Workout("Novice", R.drawable.assistedpullups, "Assisted Pull ups", "Place a sports band under your knees or use a pull up machine. Place both hands on the overhead bar facing away from you at slightly wider than the outside of your shoulders. Pull yourself up until your chin is above the bar ensuring you keep your chest out to engage your back. Imagine trying to pinch a pen in the center of your back."));
        workoutList.add(new Workout("Intermediate", R.drawable.spidermanpushup, "Spiderman Push ups", "Assume the normal push up position but this time everytime you lower yourself raise one to the side as if you are trying to touch your elbow. As you push back up bring your leg back down to its starting position and repeat with the other leg."));
        workoutList.add(new Workout("Intermediate", R.drawable.weightedsitup, "Weighted Sit ups", "This is the same as performing crunches but hold a weight across your chest while working out. Again ensure you keep your abs engaged through the whole workout to make sure you are not using your back."));
        workoutList.add(new Workout("Intermediate", R.drawable.pullup, "pull ups", "These are performed the same as the assisted Pull ups but this time there is no support ad its all just your own budy weight."));
        workoutList.add(new Workout("Advanced", R.drawable.judopushup, "Judo Push ups", "Starting in a push up position push your upper body towards your legs until your arms are fully extended so you should be in an upside down 'V'. Lower your head and shoulders to the ground and end up in the start position. As you reach the start position, continue the movement by arching your back and straightening your arms. This will push your torso upwards so that your head and chest raise and you are looking above you. Slowly inhale and push through your arms to return to the start position."));
        workoutList.add(new Workout("Advanced", R.drawable.vsits, "V sits", "Lie on your back legs straight with your hands overhead. lift your hands, shoulders and legs off the ground and try to touch your feet in the middle"));
        workoutList.add(new Workout("Advanced", R.drawable.weightedpullups, "Weighted Push ups", "This is performed the exact same way as a normal pull up but adding weight to a weight belt and performing the same actions."));

    }

    public static ArrayList<Workout> getWorkoutList() {
        return new ArrayList<Workout>(workoutList);
    }
}
