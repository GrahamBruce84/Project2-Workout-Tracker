package com.example.grahambruce.workouttracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.grahambruce.workouttracker.R.id.workoutname;

public class WorkoutDetailActivity extends AppCompatActivity implements View.OnClickListener {

    TextView workoutNameText;
    TextView workoutDescriptionText;
    ImageView workoutPicImage;
    Button plannerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_detail);

        workoutNameText = (TextView) findViewById(workoutname);
        workoutDescriptionText = (TextView) findViewById(R.id.description);
        workoutPicImage = (ImageView) findViewById(R.id.workoutpic);
        plannerButton = (Button) findViewById(R.id.planner_button);

        Bundle extras = getIntent().getExtras();
        int workoutpic = extras.getInt("workoutimage");
        String workoutname = extras.getString("workoutname");
        String workoutdesc = extras.getString("workoutdesc");

        workoutPicImage.setImageResource(workoutpic);
        workoutNameText.setText(workoutname);
        workoutDescriptionText.setText(workoutdesc);
    }

    @Override
    public void onClick(View button) {

        Intent intent = new Intent(this, PlannerListActivity.class);
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
        return super.onOptionsItemSelected(item);
    }

}
