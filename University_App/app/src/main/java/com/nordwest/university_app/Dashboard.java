package com.nordwest.university_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
    ImageView timeTable_Card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toast.makeText(getBaseContext(),"Welcome to the Dashobard",Toast.LENGTH_LONG).show();
    }
}
