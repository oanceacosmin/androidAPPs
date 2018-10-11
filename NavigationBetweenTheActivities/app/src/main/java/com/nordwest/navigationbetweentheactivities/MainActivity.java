package com.nordwest.navigationbetweentheactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText ed;
    public static String M2SEND = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Links java buttons to their XML counterparts
        btn = findViewById(R.id.id_btn);
        ed = findViewById(R.id.id_ed);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nav2Activity2();
            }
        });
    }

    private void nav2Activity2(){
        Intent i = new Intent(this, Activity2.class);
        i.putExtra(M2SEND, ed.getText().toString());
        startActivity(i);
    }
}
