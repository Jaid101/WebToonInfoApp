package com.example.webtooninfoapp;

import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseInitializer {

    public static void populateAsync(final ComicDatabase db) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> populateWithInitialData(db));
    }

    private static void populateWithInitialData(@NonNull ComicDatabase db) {
        // Example of inserting multiple comics
        Comic comic1 = new Comic("Solo Leveling", "Writer: Chugong\nArt: Redice Studio\nReads: 2.5B", R.drawable.sample_comic_image);
        Comic comic2 = new Comic("Tower of God", "Creator: SIU (Lee Jong Hui)\nRelease: 2010 – Present\nEpisode: 197\nReads: 1.2B", R.drawable.tower_of_god);
        Comic comic3 = new Comic("Hardcore Leveling Warrior", "Creator: Sehoon Kim\nEpisode: 14\nStatus: Completed\nReads: 233.3M", R.drawable.hard_core_living);
        Comic comic4 = new Comic("Noblesse", "Written by: Jeho Son\nArt by: Kwangsu Lee\nRelease: 2007 – 2019\nEpisode: 50\nReads: 439.7M", R.drawable.placeholder_image);
        Comic comic5 = new Comic("The God of High School", "Creator: Yongje Park\nRelease: 2014\nEpisode: 34\nReads: 786.1M", R.drawable.the_god_of_highschool);
        Comic comic6 = new Comic("Second Life Ranker", "Writer: Nong Nong\nIllustrator: Sa Doyeon\nChapter: 174\nRelease: 2019 – Present\nReads: 631M", R.drawable.second_life_ranker);
        Comic comic7 = new Comic("Eleceed", "Creator: Jeho Son\nArt: ZHENA\nEpisode: 278\nFrequency: Every Tuesday\nReads: 328.2M", R.drawable.placeholder_image);
        Comic comic8 = new Comic("The Advanced Player of the Tutorial Tower", "Creator: Bangguseok Gimssi\nArt: Topp\nFrequency: Every Tuesday\nReads: 139.3M", R.drawable.elecceed);
        Comic comic9 = new Comic("Leveling Up With The Gods", "Writer: Ohyeon, B.Ain\nEpisode: 110\nReads: 421M", R.drawable.leveling_up_with_the_gods);

        db.comicDao().insertComic(comic1);
        db.comicDao().insertComic(comic2);
        db.comicDao().insertComic(comic3);
        db.comicDao().insertComic(comic4);
        db.comicDao().insertComic(comic5);
        db.comicDao().insertComic(comic6);
        db.comicDao().insertComic(comic7);
        db.comicDao().insertComic(comic8);
        db.comicDao().insertComic(comic9);
    }
}
