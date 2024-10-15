package com.example.webtooninfoapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComicDetailActivity extends AppCompatActivity {
    private TextView titleTextView;
    private TextView descriptionTextView;
    private ImageView comicImageView;
    private RatingBar ratingBar;
    private Button addToFavoritesButton;
    private Comic comic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);

        titleTextView = findViewById(R.id.comic_detail_title);
        descriptionTextView = findViewById(R.id.comic_detail_description);
        comicImageView = findViewById(R.id.comic_detail_image);
        ratingBar = findViewById(R.id.rating_bar);
        addToFavoritesButton = findViewById(R.id.add_to_favorites_button);

        // Get the Comic object from the intent
        comic = (Comic) getIntent().getSerializableExtra("comic");

        // Populate the views with comic data
        if (comic != null) {
            titleTextView.setText(comic.getTitle());
            descriptionTextView.setText(comic.getDescription());
            comicImageView.setImageResource(comic.getImageResource());
            ratingBar.setRating(comic.getRating()); // Set initial rating
        }

        // Add to favorites button click listener
        addToFavoritesButton.setOnClickListener(v -> {
            addComicToFavorites(comic);
        });
    }

    private void addComicToFavorites(Comic comic) {
        comic.setFavorite(!comic.isFavorite()); // Toggle the favorite status
        ComicDatabase database = ComicDatabase.getInstance(this);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            database.comicDao().updateComic(comic); // Update the favorite status in the database
        });

        String message = comic.isFavorite() ? comic.getTitle() + " added to favorites!" : comic.getTitle() + " removed from favorites!";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
