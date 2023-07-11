package com.aimsgroup.arls.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.aimsgroup.arls.Models.GetBIdsDataModel;
import java.util.ArrayList;


public class BidsDatabase extends SQLiteOpenHelper {

    public BidsDatabase(Context context) {
        super(context, "Materials.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        try {
            //  Block of code to try
            myDB.execSQL("create table myBids(id int primary key, username text, name text , tag text, amount int, additional text, mobile text, gmail text,  time text, approval text )");
            Log.d("myBids", "onCreate: Table created");
        } catch (Exception e) {
            Log.d("myBids", "onCreate myBids Table: " + e);
        }


    }


    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop table if exists myBids");
    }


    public boolean insertBidsData(String username, String name, String tag, int amount, String additional, String mobile, String gmail, String time, String approval) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("name", name);
        contentValues.put("tag", tag);
        contentValues.put("amount", amount);
        contentValues.put("additional", additional);
        contentValues.put("mobile", mobile);
        contentValues.put("gmail", gmail);
        contentValues.put("time", time);
        contentValues.put("approval", approval);
        try {
            long result = myDB.insert("myBids", null, contentValues);
            return result != -1;
        } catch (Exception e) {
            Log.d("insert", "insertBidsData: Failed to insert");
            return false;
        }


    }
    public ArrayList<GetBIdsDataModel> readCourses() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.

        Cursor cursorCourses = db.rawQuery("SELECT * FROM myBids", null);

        // on below line we are creating a new array list.
        ArrayList<GetBIdsDataModel> getBIdsDataModels = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
//                myDB.execSQL("create table myBids(id int primary key, username text, name text , tag text, amount int, additional text, mobile text, gmail text,  time text, approval text )");
                // on below line we are adding the data from cursor to our array list.
                getBIdsDataModels.add(new GetBIdsDataModel(
                        cursorCourses.getInt(0),
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getInt(4),
                        cursorCourses.getString(5),
                        cursorCourses.getString(6),
                        cursorCourses.getString(7),
                        cursorCourses.getString(8),
                        cursorCourses.getString(9)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        db.close();
        return getBIdsDataModels;
    }


}