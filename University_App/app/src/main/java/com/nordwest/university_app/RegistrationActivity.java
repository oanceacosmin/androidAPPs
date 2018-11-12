package com.nordwest.university_app;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegistrationActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btn_register;
    Integer errorCode;
    EditText _txtFname_, _txtSname_, _txtGroup_, _txtPass_, _txtEmail_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        openHelper = new DatabaseHelper(this);
        _btn_register = findViewById(R.id.btn_reg_regAct);
        _txtFname_ = findViewById(R.id.reg_Fname);
        _txtSname_ = findViewById(R.id.reg_Sname);
        _txtEmail_ = findViewById(R.id.reg_Email);
        _txtGroup_ = findViewById(R.id.reg_Group);
        _txtPass_ = findViewById(R.id.reg_Pass);

        _btn_register.setOnClickListener(mOnRegisterClickListener);
    }



    private View.OnClickListener mOnRegisterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            {
                db = openHelper.getWritableDatabase();
                String fName = _txtFname_.getText().toString();
                String sName = _txtSname_.getText().toString();
                String email = _txtEmail_.getText().toString();
                String group = _txtGroup_.getText().toString();
                String password = _txtPass_.getText().toString();

                ContentValues contentValues = new ContentValues();

                if (isEmailValid(email) && isPasswordValid(password) && isGroupValid(group)) {
                    contentValues.put(Contract.StudentEntry.STUDENT_FNAME, fName);
                    contentValues.put(Contract.StudentEntry.STUDENT_SNAME, sName);
                    contentValues.put(Contract.StudentEntry.STUDENT_EMAIL, email);
                    contentValues.put(Contract.StudentEntry.STUDENT_GROUP, group);
                    contentValues.put(Contract.StudentEntry.STUDENT_PASWD, password);

                    db.insert(Contract.StudentEntry.TABLE_NAME, null, contentValues);
                    db.close();
                    Intent intent = new Intent(RegistrationActivity.this, Login.class);
                    setBlank();
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_LONG).show();
                }else {
                    switch (errorCode){
                        case 0:
                            Toast.makeText(getApplicationContext(), "Incorrect email provided", Toast.LENGTH_LONG).show();
                            break;
                        case 1:
                            Toast.makeText(getApplicationContext(), "Account exists already", Toast.LENGTH_LONG).show();
                            break;
                        case 2:
                            Toast.makeText(getApplicationContext(), "Incorrect chosen group name", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    };

    //check if the email is not empty and it match with and the text inserted is an email and return true or false

    private boolean isEmailValid(String userEmail){
        if (!TextUtils.isEmpty(userEmail) && Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
            Cursor cursor = db.rawQuery("SELECT _email_ FROM " + Contract.StudentEntry.TABLE_NAME + " WHERE " + Contract.StudentEntry.STUDENT_EMAIL + " =? ", new String[]{userEmail});
            if (cursor != null){
                return true;
            }
            else {
                errorCode = 1;
                _txtEmail_.setText("");
                return false;
            }
        }else {
            errorCode = 0;
            _txtEmail_.setText("");
            return false;
        }
    }

    //check if the password is not empty and return true or false

    public boolean isPasswordValid(String userPassword){
        if (!TextUtils.isEmpty(userPassword)&& (userPassword.length() > 7)){
            return true;
        }else {
            Toast.makeText(this, "Password too short", Toast.LENGTH_SHORT).show();
            _txtPass_.setText("");
            return false;
        }
    }

    public boolean isGroupValid(String userGroup){
        if (TextUtils.equals(userGroup,"IT01")|| TextUtils.equals(userGroup,"IT02") || TextUtils.equals(userGroup,"MA01")){
            return true;
        }else {
            errorCode = 2;
            _txtGroup_.setText("");
            return false;
        }
    }

    private void setBlank(){
        _txtFname_.setText("");
        _txtSname_.setText("");
        _txtGroup_.setText("");
        _txtPass_.setText("");
        _txtEmail_.setText("");
    }
}
