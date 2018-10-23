package com.example.tmhlanga.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UniSQL uni = new UniSQL(this);
        btn = findViewById(R.id.btn_nav);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nav();
            }
        });
    }
    private void nav()
    {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}
