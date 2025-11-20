package com.example.travelapp;

import java.io.Serializable;

public class Tour implements Serializable {
    String location;
    String price;
    double rating;
    int imageResId;
    private boolean isFavorite; // Thêm trường isFavorite

    public Tour(String location, String price, double rating, int imageResId) {
        this.location = location;
        this.price = price;
        this.rating = rating;
        this.imageResId = imageResId;
        this.isFavorite = false; // Mặc định là chưa yêu thích
    }

    // Getters
    public String getLocation() { return location; }
    public String getPrice() { return price; }
    public double getRating() { return rating; }
    public int getImageResId() { return imageResId; }
    public boolean isFavorite() { return isFavorite; }

    // Setter for isFavorite
    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}