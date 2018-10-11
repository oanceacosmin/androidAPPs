package com.nordwest.navigationbetweentheactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tv = findViewById(R.id.id_tv);
        Intent i = getIntent();
        String msg = i.getStringExtra(MainActivity.M2SEND);
        tv.setText(msg);
    }

    public void getTheMessage(){

    }
}
