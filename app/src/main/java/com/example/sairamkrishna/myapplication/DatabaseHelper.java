package com.example.sairamkrishna.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String databaseName = "student.db";
    public static final String area = "area";
    public static final String town = "town";
    public static final String taluk = "taluk";
    public static final String waste = "waste";
    public static final String suggestion = "suggestion";
    public static final String user = "user";
    public static final String grievance = "grievance";
    public static final String area_id = "AREA_ID";
    public static final String taluk_id = "TALUK_ID";
    public static final String taluk_name = "TALUK_NAME";
    public static final String area_name = "AREA_NAME";
    public static final String town_id = "TOWN_ID";
    public static final String town_name = "TOWN_NAME";
    public static final String waste_id = "WASTE_ID";
    public static final String waste_type = "WASTE_TYPE";
    public static final String level = "LEVEL";
    public DatabaseHelper(Context context) {
        super(context, databaseName, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+town+" (TOWN_ID numeric, TOWN_NAME varchar(100),primary key(TOWN_ID)) ");
        sqLiteDatabase.execSQL("create table "+taluk+" (TALUK_ID numeric, TALUK_NAME varchar(100),TOWN_ID numeric,primary key(TALUK_ID),foreign key(TOWN_ID) references TOWN) ");
        sqLiteDatabase.execSQL("create table "+area+" (AREA_ID numeric, AREA_NAME varchar(100),TALUK_ID numeric,TOWN_ID numeric,primary key(AREA_ID),foreign key(TALUK_ID) references TALUK, foreign key(TOWN_ID) references TOWN) ");
        sqLiteDatabase.execSQL("create table "+waste+" (WASTE_ID numeric, WASTE_TYPE numeric, AREA_ID numeric, LEVEL numeric,primary key(WASTE_ID),foreign key(AREA_ID) references AREA) ");
        sqLiteDatabase.execSQL("create table "+suggestion+" (LEVEL numeric, METHOD  numeric, WASTE_ID numeric, SOLUTION numeric, foreign key(WASTE_ID) references WASTE) ");
        sqLiteDatabase.execSQL("create table "+user+" (ID numeric,PASSWORD varchar(100),NAME varchar(100),AREA_ID numeric,PHONENUMBER numeric, EMAIL_ID varchar(100),USER_TYPE varchar(100),primary key(ID), foreign key(AREA_ID) references AREA) ");
        sqLiteDatabase.execSQL("create table "+grievance+" (G_ID numeric, AREA_ID numeric, REASON varchar(300),ID numeric,primary key(G_ID), foreign key(ID) references USER,foreign key(AREA_ID) references AREA) ");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+databaseName);
        onCreate(sqLiteDatabase);
    }
    public boolean insertTownData(String townId, String townName){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(town_id,townId);
        contentValues.put(town_name,townName);
        long result = sqLiteDatabase.insert(town,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean insertTalukData(String talukId, String talukName, String townId){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(taluk_id,talukId);
        contentValues.put(taluk_name,talukName);
        contentValues.put(town_id,townId);
        long result = sqLiteDatabase.insert(taluk,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean insertAreaData(String areaId, String areaName, String talukId, String townId){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(area_id,areaId);
        contentValues.put(area_name,areaName);
        contentValues.put(taluk_id,talukId);
        contentValues.put(town_id,townId);
        //contentValues.put(col_3,areaName);
        long result = sqLiteDatabase.insert(area,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertWasteData(String wasteId, String wasteType, String areaId, String tlevel){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(waste_id,wasteId);
        contentValues.put(waste_type,wasteType);
        contentValues.put(area_id,areaId);
        contentValues.put(level,tlevel);
        //contentValues.put(col_3,areaName);
        long result = sqLiteDatabase.insert(area,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    /*public boolean insertData(String areaId, String talukId, String areaName){
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
    }*/
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
