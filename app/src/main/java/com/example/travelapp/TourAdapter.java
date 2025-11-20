package com.example.travelapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourViewHolder> {

    private final List<Tour> tourList;

    public TourAdapter(List<Tour> tourList) {
        this.tourList = tourList;
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_tour, parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        Tour tour = tourList.get(position);
        Context context = holder.itemView.getContext();

        holder.tvTourTitle.setText(context.getString(R.string.tour_title, tour.getLocation()));
        holder.tvTourPrice.setText(tour.getPrice());
        holder.tvTourRating.setText(String.valueOf(tour.getRating()));

        Glide.with(context)
                .load(tour.getImageResId())
                .into(holder.ivTourImage);

        if (tour.isFavorite()) {
            holder.ivFavorite.setImageResource(R.drawable.ic_favorite_filled);
        } else {
            holder.ivFavorite.setImageResource(R.drawable.ic_favorite_border);
        }

        holder.ivFavorite.setOnClickListener(v -> {
            tour.setFavorite(!tour.isFavorite());
            notifyItemChanged(position);
        });

        // Xử lý sự kiện nhấn vào toàn bộ item
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, TourDetailActivity.class);
            intent.putExtra("tour", tour);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return tourList.size();
    }

    public static class TourViewHolder extends RecyclerView.ViewHolder {
        ImageView ivTourImage, ivFavorite;
        TextView tvTourTitle, tvTourPrice, tvTourRating;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);
            ivTourImage = itemView.findViewById(R.id.ivTourImage);
            ivFavorite = itemView.findViewById(R.id.ivFavorite);
            tvTourTitle = itemView.findViewById(R.id.tvTourTitle);
            tvTourPrice = itemView.findViewById(R.id.tvTourPrice);
            tvTourRating = itemView.findViewById(R.id.tvTourRating);
        }
    }
}