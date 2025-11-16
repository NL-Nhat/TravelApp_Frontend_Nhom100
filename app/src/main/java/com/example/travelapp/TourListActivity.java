package com.example.travelapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.List;

public class TourListActivity extends AppCompatActivity {

    private RecyclerView rvTourList;
    private BottomNavigationView bottomNavigation;
    private TourAdapter tourAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_list);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        rvTourList = findViewById(R.id.rvTourList);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        bottomNavigation.setSelectedItemId(R.id.nav_category);

        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                startActivity(new Intent(getApplicationContext(), IndexActivity.class));
                finish();
                return true;
            } else if (itemId == R.id.nav_category) {
                return true;
            } else if (itemId == R.id.nav_favorite) {
                startActivity(new Intent(getApplicationContext(), FavoriteActivity.class));
                finish();
                return true;
            }
            return false;
        });

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        // Sử dụng dữ liệu từ TourData
        List<Tour> tours = TourData.getInstance().getTours();
        tourAdapter = new TourAdapter(tours);

        rvTourList.setLayoutManager(new GridLayoutManager(this, 2));
        rvTourList.setAdapter(tourAdapter);
    }
}