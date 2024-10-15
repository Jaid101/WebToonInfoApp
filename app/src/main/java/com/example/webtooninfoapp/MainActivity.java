package com.example.webtooninfoapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ComicAdapter comicAdapter;
    private List<Comic> comicList;
    private ComicDatabase comicDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.comic_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        comicList = new ArrayList<>();
        comicDatabase = ComicDatabase.getInstance(this);

        // Fetch comics from the database
        fetchComicsFromDatabase();
    }

    // Fetch comics using ExecutorService instead of AsyncTask
    private void fetchComicsFromDatabase() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            List<Comic> comics = comicDatabase.comicDao().getAllComics();

            // If the database is empty, populate it with default comics
            if (comics.isEmpty()) {
                DatabaseInitializer.populateAsync(comicDatabase);

                // Fetch comics again after populating
                comics = comicDatabase.comicDao().getAllComics();
            }

            // Update UI on the main thread after fetching data
            List<Comic> finalComics = comics;
            runOnUiThread(() -> {
                comicList = finalComics;
                comicAdapter = new ComicAdapter(comicList, MainActivity.this);
                recyclerView.setAdapter(comicAdapter);
            });
        });
    }
}
