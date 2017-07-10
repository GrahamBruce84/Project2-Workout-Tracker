package com.example.grahambruce.workouttracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorkoutListActivity extends AppCompatActivity implements View.OnClickListener {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<Workout>> listHash;
    private WorkoutList workoutList;
    ArrayList<Workout> list;
    Button newWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        workoutList = new WorkoutList();
        list = workoutList.getWorkoutList();

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

        for (Workout workout : list) {
            if (workout.getLevel() == "Novice") {
                novice.add(workout);
            }
            if (workout.getLevel() == "Intermediate") {
                intermediate.add(workout);
            }
            if (workout.getLevel() == "Advanced") {
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
        Bundle extras = new Bundle();
        extras.putInt("workoutimage", workout.getImage());
        extras.putString("workoutname", workout.getName());
        extras.putString("workoutdesc", workout.getDescription());
        intent.putExtras(extras);
        startActivity(intent);
    }

}
