package com.example.sairamkrishna.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String databaseName = "student.db";
    public static final String area = "area";
    public static final String col_1 = "AREA_ID";
    public static final String col_2 = "TALUK_ID";
    public static final String col_3 = "AREA_NAME";
    public DatabaseHelper(Context context) {
        super(context, databaseName, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+area+" (AREA_ID integer, TALUK_ID integer, AREA_NAME text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+databaseName);
        onCreate(sqLiteDatabase);
    }
    public boolean insertData(String areaId, String talukId, String areaName){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,areaId);
        contentValues.put(col_2,talukId);
        contentValues.put(col_3,areaName);
        long result = sqLiteDatabase.insert(area,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+area,null);
        return res;
    }
    public Cursor getAreaData(String areaID){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+area+" where area_id = "+areaID,null);
        return res;
    }

}
