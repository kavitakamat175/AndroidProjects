package com.example.loginregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    static String dbname = "MyDatabase";
    static int version = 1;
    SQLiteDatabase sqLiteDatabase;

    public DBHelper(@Nullable Context context) {
        super(context, dbname, null, version);
        Log.i("database", "Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(username varchar(10) primary key," +
                "password varchar(8), email varchar(30), phone varchar(10), dob varchar(10))");
        Log.i("table", "table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    boolean addRecord(String un, String pwd, String mailid, String ph, String birthdate) {
        sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", un);
        contentValues.put("password", pwd);
        contentValues.put("phone", ph);
        contentValues.put("email", mailid);
        contentValues.put("dob", birthdate);
        long i = sqLiteDatabase.insert("user", null, contentValues);
        if (i > 0)
            return true;
        else
            return false;
    }

    Cursor showDetails(String un) {
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from user where username = ?", new String[]{un});
        return cursor;
    }

    boolean updateRecord(String un, String pwd, String mailid, String ph, String birthdate) {
        sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", pwd);
        contentValues.put("phone", ph);
        contentValues.put("email", mailid);
        contentValues.put("dob", birthdate);
        String[] uid=new String[]{un};
        int i=sqLiteDatabase.update("user",contentValues,"username=?",uid);
        if(i>=0)
            return true;
        else
            return false;
    }

    boolean deleteRecord(String un)
    {
        sqLiteDatabase=getWritableDatabase();
        int i=sqLiteDatabase.delete("user","username=?",new String[]{un});
        if(i>=0)
            return true;
        else
            return false;

    }
}
