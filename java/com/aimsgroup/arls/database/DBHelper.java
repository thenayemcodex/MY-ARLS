package com.aimsgroup.arls.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "UserInformation.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create table users(id int primary key, username text , fullname text, gmail text , password text , attempts text )");
        myDB.execSQL("create table materials(id int primary key,username text, name text , tag text, time text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop table if exists users");
        myDB.execSQL("drop table if exists materials");
    }



    public boolean insertData(String userName , String fullName, String gmail, String password, int attempts){
        SQLiteDatabase myDB =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",userName);
        contentValues.put("fullname",fullName);
        contentValues.put("gmail",gmail);
        contentValues.put("password",password);
        contentValues.put("attempts",attempts);
        long result = myDB.insert("users",null, contentValues);
        return result != -1;

    }
//    C:\Users\one\AndroidStudioProjects\ARLS\app\src\main\res\drawable

    public boolean checkUserCredentials(String username, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ? and password = ?", new String[] {username, password});
        if( cursor.getCount() > 0) {
            cursor.close();
            return  true;
        }else {
            cursor.close();
            return false;
        }
    }



    public boolean checkUsernameIfExists(String username) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ?", new String[] {username});
        if( cursor.getCount() > 0) {
            cursor.close();
            return  true;
        }else {
            cursor.close();
            return false;
        }
    }


    public String getUserMail(String username) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT gmail FROM users WHERE username=?", new String[]{username});
        String gmail = "";
        if (cursor.moveToFirst()) gmail = cursor.getString(0);
        cursor.close();
        sqLiteDatabase.close();
        return gmail;
    }



    public boolean ForgetPassword(String password,String gmail) {

        /* calling a method to get writable database. */
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // along with its key and value pair.
        values.put("password", password);


        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        int result = db.update("users", values, "gmail = ?", new String[] {gmail});
        db.close();
        return result > 0;
    }



//    Cart database  myDB.execSQL("create table materials(id int primary key, name text , tag text, time text )");

    public boolean insertCartData( String username,String name , String tag, String time){
        SQLiteDatabase myDB =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("name",name);
        contentValues.put("tag",tag);
        contentValues.put("time",time);

        long result = myDB.insert("materials",null, contentValues);
        return result != -1;

    }

    // below is the method for deleting our cart.
    public boolean deleteCartData(String tag, String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete("materials", "tag=? and username=?", new String[]{tag,username});
        db.close();
        return result > 0;
    }

    public boolean checkCartData(String tag , String username) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from materials where tag = ? and username = ?", new String[]{tag, username});
        if( cursor.getCount() > 0) {
            cursor.close();
            return  true;
        }else {
            cursor.close();
            return false;
        }
    }

    public String getCartTime(String tag, String username) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT time FROM materials WHERE tag=? and username = ?", new String[]{tag , username});
        String time = "";
        if (cursor.moveToFirst()) time = cursor.getString(0);
        cursor.close();
        sqLiteDatabase.close();
        return time;
    }







}
