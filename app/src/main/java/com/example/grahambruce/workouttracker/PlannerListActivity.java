package com.example.grahambruce.workouttracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class PlannerListActivity extends AppCompatActivity {

    Button deleteButton;
    ArrayList<Workout> myPlannedWorkout;
    SharedPreferences sharedPref;
    Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner_list);

        deleteButton = (Button) findViewById(R.id.delete_button);



        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
//        SharedPreferences.Editor deleter = sharedPref.edit();
//        deleter.clear();
//        deleter.apply();

        String planner = sharedPref.getString("myPlannedWorkout", new ArrayList<Workout>().toString());

        gson = new Gson();

        TypeToken<ArrayList<Workout>> workoutArrayList = new TypeToken<ArrayList<Workout>>() {
        };

        ArrayList<Workout> myPlannedWorkout = gson.fromJson(planner, workoutArrayList.getType());

        Workout newPlannedWorkout = (Workout) getIntent().getSerializableExtra("workout");

        myPlannedWorkout.add(newPlannedWorkout);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("myPlannedWorkout", gson.toJson(myPlannedWorkout));
        editor.apply();
        Toast.makeText(this, "Workout Added", Toast.LENGTH_SHORT).show();
        PlannerAdapter plannerAdapter = new PlannerAdapter(this, myPlannedWorkout);

        ListView listView = (ListView) findViewById(R.id.workout_list);
        listView.setAdapter(plannerAdapter);


    }

    public Object getItem(int position) {
        return myPlannedWorkout.get(position);
    }

    public void OnDeleteButtonClick(View view) {
        View parent = (View) view.getParent();
        String tag = parent.getTag().toString();
        for (Workout workout : myPlannedWorkout) {
            if (workout.getName().equals(tag)) {
                myPlannedWorkout.remove(workout);
                break;
            }
        }
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("myPlannedWorkout", gson.toJson(myPlannedWorkout));
        editor.apply();
        finish();
        startActivity(getIntent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_mainpage) {
            Intent intent = new Intent(this, WorkoutListActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
