package com.nordwest.university_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Timetable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        Toast.makeText(getBaseContext(),"Timetable",Toast.LENGTH_LONG).show();

    }
}
