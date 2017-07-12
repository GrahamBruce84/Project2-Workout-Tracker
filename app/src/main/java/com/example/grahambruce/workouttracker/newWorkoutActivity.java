package com.example.grahambruce.workouttracker;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class newWorkoutActivity extends AppCompatActivity implements View.OnClickListener {

    WorkoutList workoutList;
    ArrayList<Workout> workoutListArray;
    ImageButton newImageButton;
    EditText workoutTitle;
    EditText workoutDescription;
    EditText workoutLevel;
    Button saveWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);

        newImageButton = (ImageButton) findViewById(R.id.imageButton);
        workoutTitle = (EditText)findViewById(R.id.new_workout_name);
        workoutDescription = (EditText)findViewById(R.id.workout_description);
        saveWorkout = (Button) findViewById(R.id.new_workout_button);
        workoutLevel = (EditText)findViewById(R.id.workout_level);
        workoutList = new WorkoutList();
    }

    @Override
    public void onClick(View view) {
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});
        startActivity(chooserIntent);
    }

    public void createNewWorkout(View view){
        String newLevel = workoutLevel.getText().toString();
        String newTitle = workoutTitle.getText().toString();
        String newDescription = workoutDescription.getText().toString();
        Workout newWorkout = new Workout(newLevel, 0, newTitle, newDescription);
        workoutList.add(newWorkout);
        Intent intent = new Intent(this, WorkoutListActivity.class);
        intent.putExtra("workout", newWorkout);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_mainpage){
            Intent intent = new Intent(this, WorkoutListActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.action_planner){
            Intent intent = new Intent(this, PlannerListActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}


