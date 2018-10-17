package com.nordwest.sqllightapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button btn, _btnlogin;
    EditText _txtFname_, _txtSname_, _txtpass_, _txtEmail_;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper = new DatabaseHelper(this);

        btn = findViewById(R.id.id_button);
        _txtFname_ = findViewById(R.id.id_fn);
        _txtSname_ = findViewById(R.id.id_secondname);
        _txtpass_ = findViewById(R.id.id_password);
        _txtEmail_ = findViewById(R.id.id_email);
        _btnlogin = findViewById(R.id.btnlogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                String Fname = _txtFname_.getText().toString();
                String Sname = _txtSname_.getText().toString();
                String Password = _txtpass_.getText().toString();
                String Email = _txtEmail_.getText().toString();
                insertdata(Fname, Sname, Password, Email);
                Toast.makeText(getApplicationContext(), "register Succesfully", Toast.LENGTH_LONG).show();

            }
        });
        _btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }
        });
    }
    //insert data into database
     public void insertdata (String Fname, String Sname, String Password, String Email){
         ContentValues contentValues = new ContentValues();
         contentValues.put(DatabaseHelper.COL_2, Fname);
         contentValues.put(DatabaseHelper.COL_3, Sname);
         contentValues.put(DatabaseHelper.COL_4, Password);
         contentValues.put(DatabaseHelper.COL_5, Email);
         long id = db.insert(DatabaseHelper.TAABLE_NAME, null, contentValues);
     }
}
