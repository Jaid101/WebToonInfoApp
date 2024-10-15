package com.example.webtooninfoapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder> {
    private List<Comic> comicList;
    private Context context;

    public ComicAdapter(List<Comic> comicList, Context context) {
        this.comicList = comicList;
        this.context = context;
    }

    @NonNull
    @Override
    public ComicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comic_list_item, parent, false);
        return new ComicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicViewHolder holder, int position) {
        Comic comic = comicList.get(position);

        // Bind the data to the views
        holder.comicTitle.setText(comic.getTitle());
        holder.comicDescription.setText(comic.getDescription());

        // Set the image resource
        holder.comicImage.setImageResource(comic.getImageResource());

        // Handle item click event to open ComicDetailActivity
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ComicDetailActivity.class);
            intent.putExtra("comic", comic);
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }

    public static class ComicViewHolder extends RecyclerView.ViewHolder {
        TextView comicTitle, comicDescription;
        ImageView comicImage;

        public ComicViewHolder(@NonNull View itemView) {
            super(itemView);
            comicTitle = itemView.findViewById(R.id.comic_title);
            comicDescription = itemView.findViewById(R.id.comic_description);
            comicImage = itemView.findViewById(R.id.comic_image);
        }
    }
}
