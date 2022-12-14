/*
using Room for db, i added dependency for Room in
 Gradle Scripts -> build.gradle(Module)

Edited by s3821179 sang yeob,Han
*/

package com.example.registeration_a1_s3821179.Database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.registeration_a1_s3821179.Models.Notes;

@Database(entities = Notes.class, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    private static RoomDB database;
    private static final String DATABASE_NAME = "NoteAppDB";

    //method to get the instance of database
    public synchronized static RoomDB getInstance(Context context){
        if (database == null){
            database = Room.databaseBuilder(context.getApplicationContext(),
                    RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return database;
    }

    public abstract MainDAO mainDAO();
}
