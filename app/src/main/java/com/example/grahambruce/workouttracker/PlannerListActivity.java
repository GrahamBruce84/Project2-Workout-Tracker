package com.example.grahambruce.workouttracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class PlannerListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner_list);
        // Got shared preferences with a name FAVOURITES and made it private.
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        // Got a string version of our favourite movie array list from shared preferences (serialized)
        String planner = sharedPref.getString("myPlannedWorkout", new ArrayList<Workout>().toString());
        // Use GSON to deserialize our arrayList (convert string format back to ArrayList)
        Gson gson = new Gson();
        // Tells GSON what to convert JSON back to. in this case ArrayList.
        TypeToken<ArrayList<Workout>> workoutArrayList = new TypeToken<ArrayList<Workout>>() {
        };
        // Gets JSON data and converts to ArrayList<Movie>
        ArrayList<Workout> myPlannedWorkout = gson.fromJson(planner, workoutArrayList.getType());
        // Create a new favourite move object from the ListView item
        Workout newPlannedWorkout = (Workout) getIntent().getSerializableExtra("workout");
        // Add to ArrayList
        myPlannedWorkout.add(newPlannedWorkout);
        SharedPreferences.Editor editor = sharedPref.edit();
        // Convert ArrayList to JSON (string object) and save to shared preferences
        editor.putString("myPlannedWorkout", gson.toJson(myPlannedWorkout));
        editor.apply();
        Toast.makeText(this, "Workout Added", Toast.LENGTH_SHORT).show();

        TextView list = (TextView) findViewById(R.id.workout_title);
        list.setText(newPlannedWorkout.getName());
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
        return super.onOptionsItemSelected(item);
    }
}
