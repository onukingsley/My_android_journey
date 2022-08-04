package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    String TABLE_NAME = "users";
    private static String DBNAME = "ADMINDB";
    private static int DBVERSION = 1;


    public DBhelper(@Nullable Context context) {
        super(context, DBNAME,null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+ TABLE_NAME + " (NAME TEXT,USERNAME TEXT,GRADE TEXT, ID INTEGER PRIMARY KEY AUTOINCREMENT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
    }

    public boolean insertIntoDB(String name, String username, String grade){
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("USERNAME",username);
        contentValues.put("GRADE",grade);
        SQLiteDatabase db = getWritableDatabase();
        long result = db.insert(TABLE_NAME,null,contentValues);
        db.close();

        if (result>=0){
            return true;
        }
        return false;
    }
    public Cursor fetchData(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return cursor;
    }
    public boolean update(String name, String username, String grade, String id){
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("USERNAME",username);
        contentValues.put("GRADE",grade);
        SQLiteDatabase db = getWritableDatabase();
        long result = db.update(TABLE_NAME,contentValues,"id = ?", new String[]{id});
        db.close();

        if (result>=0){
            return true;
        }
        return false;
    }

    public boolean delete (String id){
        SQLiteDatabase db = getWritableDatabase();
        int result = db.delete(TABLE_NAME,"id = ?",new String[]{id});
        db.close();

        if (result==1){
            return true;
        }return false;
    }
}
