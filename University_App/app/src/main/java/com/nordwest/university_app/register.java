package com.nordwest.university_app;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class register extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btn_register;
    EditText _txtFname_, _txtSname_, _txtAddress_, _txtPass_, _txtEmail_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        openHelper = new DatabaseHelper(this);
        _btn_register = findViewById(R.id.btn_reg_regAct);
        _txtFname_ = findViewById(R.id.reg_Fname);
        _txtSname_ = findViewById(R.id.reg_Sname);
        _txtEmail_ = findViewById(R.id.reg_Email);
        _txtAddress_ = findViewById(R.id.reg_Address);
        _txtPass_ = findViewById(R.id.reg_Pass);

        _btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db = openHelper.getWritableDatabase();
                String Fname = _txtFname_.getText().toString();
                String Sname = _txtSname_.getText().toString();
                String Email = _txtEmail_.getText().toString();
                String Address = _txtAddress_.getText().toString();
                String Password = _txtPass_.getText().toString();

                ContentValues contentValues = new ContentValues();
                contentValues.put(Contract.StudentEntry.STUDENT_FNAME,Fname);
                contentValues.put(Contract.StudentEntry.STUDENT_SNAME,Sname);
                contentValues.put(Contract.StudentEntry.STUDENT_EMAIL,Email);
                contentValues.put(Contract.StudentEntry.STUDENT_ADDRESS,Address);
                contentValues.put(Contract.StudentEntry.STUDENT_PASWD,Password);
                db.insert(Contract.StudentEntry.TABLE_NAME, null, contentValues);
                db.close();
                Intent intent = new Intent(register.this,Login.class);
                startActivity(intent);

                 Log.d("Database Operations","New record inserted in table "+ Contract.StudentEntry.TABLE_NAME);
                Toast.makeText(getApplicationContext(), "register Succesfully", Toast.LENGTH_LONG).show();
            }


        });




    }




}
