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
    public static final String method = "METHOD";
    public static final String solution = "SOLUTION";
    public static final String id = "ID";
    public static final String password = "PASSWORD";
    public static final String reason = "REASON";
    public static final String name = "NAME";
    public static final String phone_number = "PHONENUMBER";
    public static final String email_id = "EMAIL_ID";
    public static final String user_type = "USER_TYPE";
    public static final String col_1 = "LEVEL";
    public static final String col_2 = "LEVEL";
    public static final String col_3 = "LEVEL";
    public DatabaseHelper(Context context) {
        super(context, databaseName, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+town+" (TOWN_ID integer, TOWN_NAME text,primary key(TOWN_ID))");
        sqLiteDatabase.execSQL("create table "+taluk+" (TALUK_ID integer, TALUK_NAME text,TOWN_ID integer,primary key(TALUK_ID),foreign key(TOWN_ID) references TOWN(TOWN_ID)) ");
        sqLiteDatabase.execSQL("create table "+area+" (AREA_ID integer, AREA_NAME text,TALUK_ID integer,TOWN_ID integer,primary key(AREA_ID),foreign key(TALUK_ID) references TALUK(TALUK_ID), foreign key(TOWN_ID) references TOWN(TOWN_ID)) ");
        sqLiteDatabase.execSQL("create table "+waste+" (WASTE_ID integer, WASTE_TYPE integer, AREA_ID integer, LEVEL integer,primary key(WASTE_ID),foreign key(AREA_ID) references AREA(AREA_ID)) ");
        sqLiteDatabase.execSQL("create table "+suggestion+" (LEVEL integer, METHOD  text, WASTE_ID integer, SOLUTION text, foreign key(WASTE_ID) references WASTE(WASTE_ID)) ");
        sqLiteDatabase.execSQL("create table "+user+" (ID integer,PASSWORD text,NAME text,AREA_ID integer,PHONENUMBER integer, EMAIL_ID text,USER_TYPE text,primary key(ID), foreign key(AREA_ID) references AREA(AREA_ID)) ");
        sqLiteDatabase.execSQL("create table "+grievance+" (G_ID integer, AREA_ID integer, REASON varchar(300),ID integer,primary key(G_ID), foreign key(ID) references USER(ID),foreign key(AREA_ID) references AREA(AREA_ID)) ");

//        sqLiteDatabase.execSQL("insert into "+town+" values(1,'Pallet')");
//        sqLiteDatabase.execSQL("insert into "+town+" values(2,'Littleroot')");
//        sqLiteDatabase.execSQL("insert into "+town+" values(3,'Twinleaf')");
//        sqLiteDatabase.execSQL("insert into "+taluk+" values(101,'Oldale',1)");
//        sqLiteDatabase.execSQL("insert into "+taluk+" values(102,'Snowpoint',1)");
//        sqLiteDatabase.execSQL("insert into "+taluk+" values(103,'Veilstone',2)");
//        sqLiteDatabase.execSQL("insert into "+taluk+" values(104,'Rustboro',2)");
//        sqLiteDatabase.execSQL("insert into "+taluk+" values(105,'Fortree',3)");
//        sqLiteDatabase.execSQL("insert into "+taluk+" values(106,'Lumiose',3)");
//        sqLiteDatabase.execSQL("insert into "+area+" values(201,'Lavender',101,1)");
//        sqLiteDatabase.execSQL("insert into "+area+" values(202,'Hearthome',101,1)");
//        sqLiteDatabase.execSQL("insert into "+area+" values(203,'Eterna',102,1)");
//        sqLiteDatabase.execSQL("insert into "+area+" values(204,'Lavaridge',102,1)");
//        sqLiteDatabase.execSQL("insert into "+area+" values(205,'Castelia',103,2)");
//        sqLiteDatabase.execSQL("insert into "+area+" values(206,'Aspertia',103,2)");
//        sqLiteDatabase.execSQL("insert into "+area+" values(207,'Driftveil',104,2)");
//        sqLiteDatabase.execSQL("insert into "+area+" values(208,'Mossdeep',104,2)");
//        sqLiteDatabase.execSQL("insert into "+area+" values(209,'Viridian',105,3)");
//        sqLiteDatabase.execSQL("insert into "+area+" values(210,'Lilycove',105,3)");
//        sqLiteDatabase.execSQL("insert into "+area+" values(211,'Dewford',106,3)");
//        sqLiteDatabase.execSQL("insert into "+area+" values(212,'Petalburg',106,3)");
//
//        sqLiteDatabase.execSQL("insert into "+waste+" values(1001,'Plastic',201,3)");
//        sqLiteDatabase.execSQL("insert into "+waste+" values(1002,'Rubber',202,2)");
//        sqLiteDatabase.execSQL("insert into "+waste+" values(1001,'Plastic',203,3)");
//        sqLiteDatabase.execSQL("insert into "+waste+" values(1003,'Medical',201,3)");
//        sqLiteDatabase.execSQL("insert into "+waste+" values(1004,'Household',205,1)");
//        sqLiteDatabase.execSQL("insert into "+waste+" values(1005,'Metals',206,4)");
//        sqLiteDatabase.execSQL("insert into "+waste+" values(1006,'Radioactive',207,5)");
//        sqLiteDatabase.execSQL("insert into "+waste+" values(1002,'Rubber',208,2)");
//        sqLiteDatabase.execSQL("insert into "+waste+" values(1003,'Medical',209,3)");
//        sqLiteDatabase.execSQL("insert into "+waste+" values(1004,'Household',210,1)");
//        sqLiteDatabase.execSQL("insert into "+waste+" values(1006,'Radioactive',211,5)");
//        sqLiteDatabase.execSQL("insert into "+waste+" values(1001,'Plastic',212,3)");
//
//
//        sqLiteDatabase.execSQL("insert into "+suggestion+" values(3,'Land Fills',1001,'Never use incineration')");
//        sqLiteDatabase.execSQL("insert into "+suggestion+" values(2,'Land Fills',1002,'Never use incineration')");
//        sqLiteDatabase.execSQL("insert into "+suggestion+" values(3,'Incineration',1003,'Should be disposed with care')");
//        sqLiteDatabase.execSQL("insert into "+suggestion+" values(1,'Any method',1004,'Could be recycled')");
//        sqLiteDatabase.execSQL("insert into "+suggestion+" values(4,'Mass deposition',1005,'Can be reused')");
//        sqLiteDatabase.execSQL("insert into "+suggestion+" values(5,'Safe containment',1001,'Highly Dangerous')");
//
//        sqLiteDatabase.execSQL("insert into "+user+" values(20001,'yogesh','yogesh',201,9898989898,'yogesh@gmail.com','user')");
//        sqLiteDatabase.execSQL("insert into "+user+" values(20002,'sanjay','sanjay',203,9797979797,'sanjay@gmail.com','user')");
//        sqLiteDatabase.execSQL("insert into "+user+" values(20003,'goutham','goutham',207,9696969696,'goutham@gmail.com','user')");
//        sqLiteDatabase.execSQL("insert into "+user+" values(20004,'nithin','nithin',209,8686868686,'nithin@gmail.com','user')");
//        sqLiteDatabase.execSQL("insert into "+user+" values(20005,'admin','admin',211,7676767676,'admin@gmail.com','admin')");

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
    public boolean insertTalukData(String townId,String talukId, String talukName){
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
    public boolean insertAreaData(String talukId, String areaId, String areaName, String townId){
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
        long result = sqLiteDatabase.insert(waste,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertSuggestionData(String tlevel, String tmethod, String wasteId, String tsolution){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(level,tlevel);
        contentValues.put(method,tmethod);
        contentValues.put(waste_id,wasteId);
        contentValues.put(solution,tsolution);
        //contentValues.put(col_3,areaName);
        long result = sqLiteDatabase.insert(suggestion,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertUserData(String tid, String tpassword, String tname, String areaId, String phoneNumber, String emailId, String userType){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(id,tid);
        contentValues.put(password,tpassword);
        contentValues.put(name,tname);
        contentValues.put(area_id,areaId);
        contentValues.put(phone_number,phoneNumber);
        contentValues.put(email_id,emailId);
        contentValues.put(user_type,userType);
        //contentValues.put(col_3,areaName);
        long result = sqLiteDatabase.insert(user,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertGrievanceData(String gId, String areaId, String treason, String tid){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(id,gId);
        contentValues.put(area_id,areaId);
        contentValues.put(reason,treason);
        contentValues.put(id,tid);
        //contentValues.put(col_3,areaName);
        long result = sqLiteDatabase.insert(grievance,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
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
    public Cursor getWasteData(String areaID){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+waste+" where area_id = "+areaID,null);
        return res;
    }
    public Cursor getGrievanceData(String areaID){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+grievance+" where area_id = "+areaID,null);
        return res;
    }
    public Cursor getSuggestionData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+suggestion,null);
        return res;
    }
    public Cursor getLoginData(String inputId){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select id,password,user_type from "+user+" where id = '"+inputId+"'",null);
        return res;
    }
    public Cursor checkAreaData(String areaID){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+area+" where area_id = "+areaID,null);
        return res;
    }

}
