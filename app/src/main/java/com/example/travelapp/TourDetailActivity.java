package com.example.travelapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class TourDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ImageView ivTourImageDetail = findViewById(R.id.ivTourImageDetail);
        TextView tvTourTitleDetail = findViewById(R.id.tvTourTitleDetail);
        TextView tvRatingDetail = findViewById(R.id.tvRatingDetail);
        TextView tvLocationDetail = findViewById(R.id.tvLocationDetail);
        TextView tvPriceDetail = findViewById(R.id.tvPriceDetail);
        TextView tvPriceBottom = findViewById(R.id.tvPriceBottom);
        ImageView ivFavoriteDetail = findViewById(R.id.ivFavoriteDetail);
        ImageView ivBack = findViewById(R.id.ivBack);
        Button btnBookNow = findViewById(R.id.btnBookNow);

        // Lấy dữ liệu tour từ Intent
        Tour tour = (Tour) getIntent().getSerializableExtra("tour");

        if (tour != null) {
            // Đổ dữ liệu vào các view
            Glide.with(this).load(tour.getImageResId()).into(ivTourImageDetail);
            tvTourTitleDetail.setText("Tour Du Lịch - " + tour.getLocation());
            tvRatingDetail.setText(String.format("%s (%d lượt đánh giá)", tour.getRating(), 12456)); // Giả sử số lượt đánh giá
            tvLocationDetail.setText(tour.getLocation() + ", Việt Nam");
            String priceText = "Từ " + tour.getPrice() + " mỗi người";
            tvPriceDetail.setText(priceText);
            tvPriceBottom.setText("Từ " + tour.getPrice() + "VND");

            // Cập nhật trạng thái yêu thích
            if (tour.isFavorite()) {
                ivFavoriteDetail.setImageResource(R.drawable.ic_favorite_filled);
            } else {
                ivFavoriteDetail.setImageResource(R.drawable.ic_favorite_border);
            }
        }

        // Xử lý sự kiện nút quay lại
        ivBack.setOnClickListener(v -> finish());
    }
}