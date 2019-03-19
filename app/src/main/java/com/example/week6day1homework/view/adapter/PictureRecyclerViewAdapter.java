package com.example.week6day1homework.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week6day1homework.R;
import com.example.week6day1homework.model.datasource.remote.Item;
import com.example.week6day1homework.model.datasource.remote.Media;
import com.example.week6day1homework.model.datasource.remote.PictureResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Component;

public class PictureRecyclerViewAdapter extends RecyclerView.Adapter<PictureRecyclerViewAdapter.ViewHolder> {
@Inject
    List<Item> pictureResponses;




public PictureRecyclerViewAdapter(PictureResponse pictureResponse){

    this.pictureResponses = pictureResponse.getItems();


}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.picture_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
Item response = pictureResponses.get(i);
viewHolder.tvAuthor.setText(response.getAuthor());
viewHolder.tvTitle.setText(response.getTitle());
        Glide.with(viewHolder.itemView.getContext()).load(response.getMedia().toString()).into(viewHolder.imgViewImage);




    }

    @Override
    public int getItemCount() {
        return pictureResponses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
ImageView imgViewImage;
TextView tvTitle;
TextView tvAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgViewImage = itemView.findViewById(R.id.imgItemImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);

        }
    }
}
