package com.example.hostelgrievances;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBClass extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "HostelComplaints";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_WATER = "WaterComplaints";
    private static final String Complaint_ID = "ID";
    private static final String Name = "Name";
    private static final String Room_Number = "Room_Number";
    private static final String ISSUE = "Issue";

    public DBClass(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_WATER + "(" + Complaint_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Name + " TEXT," + Room_Number + " INTEGER," + ISSUE + " TEXT" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WATER);
        onCreate(db);

    }

    public void insert(String name,String room,String issue){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Name,name);
        cv.put(Room_Number,room);
        cv.put(ISSUE,issue);
        db.insert(TABLE_WATER,null,cv);
    }

/*    public ArrayList<Model> fetch(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_WATER,null);
        ArrayList<Model> details = new ArrayList<>();

        while(c.moveToNext()){
            Model m = new Model();
            m.id = c.getInt(0);
            m.name = c.getString(1);
            m.room = c.getString(2);
            m.issue = c.getString(3);

            details.add(m);
        }
        return details;
    }*/
    public void delete(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_WATER,null,null);
        Log.d("RESULT","Deleted successfully");
        db.close();
    }
}
