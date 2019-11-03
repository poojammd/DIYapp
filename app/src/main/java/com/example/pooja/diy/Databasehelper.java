package com.example.pooja.diy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.Nullable;

public class Databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="registeruser";
    public static final String COL_1="ID";
    public static final String COL_2="email";
    public static final String COL_3="password";

    public Databasehelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
        getWritableDatabase().execSQL(" Create table if not exists registeruser (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `email` varchar(50), `password` varchar(50));");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addUser(ContentValues contentValues)
    {

        getWritableDatabase().insert("registeruser",null,contentValues);


    }

    public boolean checkUser (String email, String password)
    {
        String [] columns={COL_1};
        SQLiteDatabase db=getReadableDatabase();
        String selection=COL_2 + "=?" + " and " + COL_3 + "=?";
        String [] selectionArgs={email,password};
        Cursor cursor=db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count=cursor.getCount();
        cursor.close();
        db.close();
        if(count>0)
        {
            return true;
        }
        else return  false;


    }
}
