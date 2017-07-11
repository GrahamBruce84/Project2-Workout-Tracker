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
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorkoutListActivity extends AppCompatActivity implements View.OnClickListener {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<Workout>> listHash;
    private ArrayList<Workout> workoutList;
    Button newWorkout;
    SharedPreferences sharedPref;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        sharedPref = getSharedPreferences(getString(R.string.preference_list_key), Context.MODE_PRIVATE);
//        SharedPreferences.Editor deleter = sharedPref.edit();
//        deleter.clear();
//        deleter.apply();

        String workList = sharedPref.getString("workoutList", new ArrayList<Workout>().toString());

        gson = new Gson();

        TypeToken<ArrayList<Workout>> workoutArrayList = new TypeToken<ArrayList<Workout>>() {
        };

         workoutList = gson.fromJson(workList, workoutArrayList.getType());

//        workoutList = new WorkoutList().getWorkoutListArray();
        if(getIntent().getExtras() != null) {
            Workout newWorkout = (Workout) getIntent().getExtras().get("workout");

            workoutList.add(newWorkout);
        }
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("workoutList", gson.toJson(workoutList));
        editor.apply();
        Toast.makeText(this, "Workout Added", Toast.LENGTH_SHORT).show();

        listView = (ExpandableListView) findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);

        listView.setAdapter(listAdapter);
        newWorkout = (Button)findViewById(R.id.new_workout_button);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Novice");
        listDataHeader.add("Intermediate");
        listDataHeader.add("Advanced");

        ArrayList<Workout> novice = new ArrayList<>();
        ArrayList<Workout> intermediate = new ArrayList<>();
        ArrayList<Workout> advanced = new ArrayList<>();

        for (Workout workout : workoutList) {
            if (workout.getLevel().equals("Novice")) {
                novice.add(workout);
            }
            if (workout.getLevel().equals("Intermediate")) {
                intermediate.add(workout);
            }
            if (workout.getLevel().equals("Advanced")) {
                advanced.add(workout);
            }

            listHash.put(listDataHeader.get(0), novice);
            listHash.put(listDataHeader.get(1), intermediate);
            listHash.put(listDataHeader.get(2), advanced);

        }
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

    public void onClickNewWorkout(View button){
        Intent intent = new Intent(this, newWorkoutActivity.class);
        startActivity(intent);
    }

    public void onClick(View listItem) {
        Workout workout = (Workout) listItem.getTag();
        Intent intent = new Intent(this, WorkoutDetailActivity.class);
        intent.putExtra("workout", workout);
        startActivity(intent);
    }

}
