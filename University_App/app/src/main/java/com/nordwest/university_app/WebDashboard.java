package com.nordwest.university_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class WebDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_dashboard);
        Toast.makeText(getBaseContext(),"Dashboard",Toast.LENGTH_LONG).show();

    }
}
