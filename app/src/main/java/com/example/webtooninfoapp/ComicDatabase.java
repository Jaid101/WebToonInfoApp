package com.example.webtooninfoapp;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Comic.class}, version = 1, exportSchema = false)
public abstract class ComicDatabase extends RoomDatabase {
    public abstract ComicDao comicDao(); // Abstract method to get ComicDao

    private static ComicDatabase instance;

    // Singleton pattern to get the database instance
    public static synchronized ComicDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            ComicDatabase.class, "comic_database")
                    .fallbackToDestructiveMigration() // Handle database schema changes
                    .build();
        }
        return instance; // Return the instance
    }
}
