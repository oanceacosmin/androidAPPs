package com.example.tmhlanga.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UniSQL extends SQLiteOpenHelper
{

    private static final String DB_NAME = "uni_db";
    private static final int VERSION = 1;
    SQLiteDatabase dbo;

    public UniSQL(Context context) {
        super(context, DB_NAME, null, VERSION);
        dbo = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS " +
                UniContract.User.TABLE_NAME +
                "(" + UniContract.User.SID + "text, " +
                UniContract.User.FN + "text, " +
                UniContract.User.SN + "text, " +
                UniContract.User.EM + "text, " +
                UniContract.User.GROUP + "text, " +
                UniContract.User.PW + "text);";

        Log.d("Query", CREATE_USER_TABLE);
        db.execSQL(CREATE_USER_TABLE);


        final String CREATE_UNI_GROUP = "CREATE TABLE IF NOT EXISTS " +
                UniContract.Uni_Group.TABLE_NAME+
                "(" + UniContract.Uni_Group.GROUP_ID + "text); " ;

        Log.d("Query", CREATE_UNI_GROUP);
        db.execSQL(CREATE_UNI_GROUP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void register(String fn, String sn, String em, String group, String pw)
    {
        dbo = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(UniContract.User.FN, fn);
        cv.put(UniContract.User.SN, sn);
        cv.put(UniContract.User.EM, em);
        cv.put(UniContract.User.PW, pw);
        cv.put(UniContract.User.GROUP, group);
        dbo.insert(UniContract.User.TABLE_NAME, null,null,cv);
    }



}









