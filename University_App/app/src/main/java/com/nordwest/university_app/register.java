package com.nordwest.university_app;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    // variable declaration
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btn_registration, _btnlogin;
    EditText _txt_FirstName, _txt_SecondName, _txt_Email, _txt_Address, _txt_PassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //create new database helper
        openHelper = new DatabaseHelper(this);

        _btn_registration = findViewById(R.id.btn_reg_regAct);
        _txt_FirstName = findViewById(R.id.reg_Fname);
        _txt_SecondName = findViewById(R.id.reg_Sname);
        _txt_Email = findViewById(R.id.reg_Email);
        _txt_Address = findViewById(R.id.reg_Address);
        _txt_PassWord = findViewById(R.id.reg_Pass);

        _btn_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                String Fname = _txt_FirstName.getText().toString();
                String Sname = _txt_SecondName.getText().toString();
                String Email = _txt_Email.getText().toString();
                String Address = _txt_Address.getText().toString();
                String Password = _txt_PassWord.getText().toString();
                insertdata(Fname, Sname, Email, Address, Password);
                Toast.makeText(getApplicationContext(), "register Succesfully", Toast.LENGTH_LONG).show();
                ClearEdit();
            }
        });


    }

    public void ClearEdit() {
        _txt_FirstName.setText("");
        _txt_SecondName.setText("");
        _txt_Email.setText("");
        _txt_Address.setText("");
        _txt_PassWord.setText("");
    }
//    public boolean Dubble(String Email) {
//        return false;
//    }

    //insert data into database
    public void insertdata(String Fname, String Sname, String Email, String Address, String Password) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, Fname);
        contentValues.put(DatabaseHelper.COL_3, Sname);
        contentValues.put(DatabaseHelper.COL_4, Email);
        contentValues.put(DatabaseHelper.COL_5, Address);
        contentValues.put(DatabaseHelper.COL_6, Password);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }
}
