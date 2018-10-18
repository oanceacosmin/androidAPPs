 package com.nordwest.university_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


 public class MainActivity extends AppCompatActivity {

     SQLiteDatabase db;
     SQLiteOpenHelper openHelper;
     Button btn_login, btn_register;
     EditText _txtEmail, _txtPass;
     Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_registration);
        openHelper = new DatabaseHelper(this);
        _txtEmail = findViewById(R.id.login_email);
        _txtPass = findViewById(R.id.pass_login);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, register.class);
                startActivity(intent);
                Log.d("Database Operations","moved to registration activity ");

            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = _txtEmail.getText().toString();
                String passWord = _txtPass.getText().toString();

                Log.d("Database Operations","moved to registration activity " + email);
                Toast.makeText(getApplicationContext(), "data retrived" + email,Toast.LENGTH_LONG).show();


            }
        });



    }

     public void displayAllert (String title, String content){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage("sdfadsa" + content);

     }
 }
