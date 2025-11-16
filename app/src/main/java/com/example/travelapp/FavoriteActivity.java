package com.example.travelapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.List;
import java.util.stream.Collectors;

public class FavoriteActivity extends AppCompatActivity {

    private RecyclerView rvFavoriteTours;
    private TourAdapter tourAdapter;
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        rvFavoriteTours = findViewById(R.id.rvFavoriteTours);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        bottomNavigation.setSelectedItemId(R.id.nav_favorite);

        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                startActivity(new Intent(getApplicationContext(), IndexActivity.class));
                finish();
                return true;
            } else if (itemId == R.id.nav_category) {
                startActivity(new Intent(getApplicationContext(), TourListActivity.class));
                finish();
                return true;
            } else if (itemId == R.id.nav_favorite) {
                return true;
            }
            return false;
        });

        setupRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Cập nhật lại danh sách mỗi khi quay lại màn hình này
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        // Lọc danh sách tour để chỉ lấy những tour được yêu thích
        List<Tour> favoriteTours = TourData.getInstance().getTours().stream()
                .filter(Tour::isFavorite)
                .collect(Collectors.toList());

        tourAdapter = new TourAdapter(favoriteTours);
        rvFavoriteTours.setLayoutManager(new GridLayoutManager(this, 2));
        rvFavoriteTours.setAdapter(tourAdapter);
    }
}