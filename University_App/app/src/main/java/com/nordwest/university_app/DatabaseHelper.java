package com.nordwest.university_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//extend with SQL class in order to get access to DB

public class DatabaseHelper extends SQLiteOpenHelper {
    //created the constant variables that contain important unchangeable values related to DB

    public static final String DATABASE_NAME = "uniRegTab.db";
    public static final String TABLE_NAME = "reg_students";
    public static final String COL_1 = "stud_ID";
    public static final String COL_2 = "stud_Fname";
    public static final String COL_3 = "stud_Sname";
    public static final String COL_4 = "stud_Email";
    public static final String COL_5 = "stud_Adress";
    public static final String COL_6 = "stud_PssWord";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    //create the db one the app is running
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_NAME+ "(Student_ID INTEGER PRIMARY KEY AUTOINCREMENT, FirstName TEXT, LastName TEXT, Email TEXT, Address TEXT, Password TEXT)");
    }
    //Drop table if exists before creation
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }
}
