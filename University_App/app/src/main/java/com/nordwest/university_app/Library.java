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
import android.widget.TextView;
import android.widget.Toast;

public class Library extends AppCompatActivity {


    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button buttondb;
    EditText editTextdb;
    TextView textViewdb;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        Toast.makeText(getBaseContext(),"Library",Toast.LENGTH_LONG).show();

        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        /*Creates the link between layout widgets (elements) and activity objects  */
        buttondb = findViewById(R.id.buttondb);
        editTextdb = findViewById(R.id.editTextdb);
        textViewdb = findViewById(R.id.textViewdb);

        buttondb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice,books =null;
                choice = editTextdb.getText().toString();
                cursor = db.query("_book_",null,"_category_type_ = 'drama'",null,null,null,null);
                if (cursor != null){
                    if (cursor.moveToFirst()){
                        do{
                            books = books + cursor.getString(cursor.getColumnIndex("_title_"));
                            /*Contract.StudentEntry.actualUserSecondName= cursor.getString(cursor.getColumnIndex(Contract.StudentEntry.STUDENT_SNAME));
                            Contract.StudentEntry.actualUserStudentID= cursor.getString(cursor.getColumnIndex(Contract.StudentEntry.STUDENT_ID));
                            Contract.StudentEntry.actualUserEmail= cursor.getString(cursor.getColumnIndex(Contract.StudentEntry.STUDENT_EMAIL));
                            Contract.StudentEntry.actualUserGroupName= cursor.getString(cursor.getColumnIndex(Contract.StudentEntry.STUDENT_GROUP))*/;

                        }while (cursor.moveToNext());
                        //Toast.makeText(getApplicationContext(), "Welcome to the dashboard " + Contract.StudentEntry.actualUserFirstName +"!", Toast.LENGTH_LONG).show();
/*
                        Intent intent = new Intent(Library.this, Dashboard.class);
                        startActivity(intent);*/

                            textViewdb.setText(books);
                    }else {
                        Toast.makeText(getApplicationContext(),"error", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
