package com.example.dictionary.word.job;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance
    (Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {

        this.database = openHelper.getWritableDatabase();
    }


    /**
     * Read all fals from the database.
     *
     * @return a List of fal
     */
    public Cursor getJob(String _id) {
        open();
        Cursor cursor = database.rawQuery(
                "SELECT * FROM jobTbl where _id= " + _id,
                null);
        return cursor;

    }

}
