package com.example.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
private static String dbName="Mydb";
private static int version =1;
SQLiteDatabase sqLiteDatabase;

    public DBHelper(Context context) {
        super(context, dbName, null, version);
        Log.i("database","database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table emp(empcode int primary key, ename varchar2(10))");
    Log.i("table","table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addRec(int ecode,String enm){
        sqLiteDatabase= getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("empcode",ecode);
        contentValues.put("ename",enm);
        long rec= sqLiteDatabase.insert("emp",null, contentValues);
        if (rec>0)
            return true;
        else
            return false;



    }
}
