package com.example.grahambruce.workouttracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.R.id.list;
import static android.R.string.no;

public class WorkoutListActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        listView = (ExpandableListView)findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Novice");
        listDataHeader.add("Intermediate");
        listDataHeader.add("Advanced");

        List<String> novice = new ArrayList<>();
        novice.add("Push ups");
        novice.add("Sit ups");
        novice.add("Assisted Pull ups");

        List<String> intermediate = new ArrayList<>();
        intermediate.add("Spiderman Push ups");
        intermediate.add("Weighted Sit ups");
        intermediate.add("Pull ups");

        List<String> advanced = new ArrayList<>();
        advanced.add("Judo Push up");
        advanced.add("V Sit ups");
        advanced.add("Weighted Pull ups");

        listHash.put(listDataHeader.get(0), novice);
        listHash.put(listDataHeader.get(1), intermediate);
        listHash.put(listDataHeader.get(2), advanced);
    }


}
