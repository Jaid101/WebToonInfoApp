package com.example.webtooninfoapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "comics")
public class Comic implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private int imageResource;
    private float rating; // Field for rating
    private boolean isFavorite; // Field to indicate if the comic is a favorite

    // Constructor
    public Comic(String title, String description, int imageResource) {
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
        this.rating = 0; // Initialize rating to 0
        this.isFavorite = false; // Initialize as not favorite
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
