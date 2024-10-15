package com.example.webtooninfoapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ComicDao {
    @Insert
    void insertComic(Comic comic);

    @Query("SELECT * FROM comics")
    List<Comic> getAllComics(); // Fetch all comics

    @Update
    void updateComic(Comic comic); // Method to update the comic
}
