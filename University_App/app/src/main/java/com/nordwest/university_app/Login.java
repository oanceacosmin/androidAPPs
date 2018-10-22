package com.nordwest.university_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button btn_log_in;
    EditText user_email, user_pass;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        btn_log_in = findViewById(R.id.btn_log_in);
        user_email = findViewById(R.id.login_email);
        user_pass = findViewById(R.id.pass_login);

        btn_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = user_email.getText().toString();
                String pass = user_pass.getText().toString();
                cursor = db.rawQuery("SELECT * FROM " +Contract.StudentEntry.TABLE_NAME+ " WHERE " +Contract.StudentEntry.STUDENT_EMAIL +" =? AND " + Contract.StudentEntry.STUDENT_PASWD + " =? ", new String[]{email, pass});
                if (cursor != null){
                    if (cursor.getCount() > 0){
                        Toast.makeText(getApplicationContext(), "Login successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Login.this, Dashboard.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(),"error", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }

}
