package com.example.travelapp;

import java.util.ArrayList;
import java.util.List;

public class TourData {

    private static TourData instance;
    private final List<Tour> tours;

    private TourData() {
        tours = new ArrayList<>();
        // Khởi tạo dữ liệu mẫu để lấy dữ liệu mẫu cho Adapter
        tours.add(new Tour("Đà Nẵng", "$100", 5.0, R.drawable.da_nang));
        tours.add(new Tour("Hà Nội", "$120", 4.8, R.drawable.ha_noi));
        tours.add(new Tour("Quảng Ninh", "$150", 4.9, R.drawable.quang_ninh));
        tours.add(new Tour("Cao Bằng", "$90", 4.7, R.drawable.cao_bang));
        tours.add(new Tour("Hội An", "$110", 4.9, R.drawable.da_nang));
        tours.add(new Tour("Sapa", "$130", 4.8, R.drawable.ha_noi));
        tours.add(new Tour("Hạ Long", "$160", 5.0, R.drawable.quang_ninh));
        tours.add(new Tour("Bản Giốc", "$95", 4.7, R.drawable.cao_bang));
        tours.add(new Tour("Phú Quốc", "$200", 5.0, R.drawable.da_nang));
        tours.add(new Tour("Nha Trang", "$180", 4.9, R.drawable.ha_noi));
    }

    public static synchronized TourData getInstance() {
        if (instance == null) {
            instance = new TourData();
        }
        return instance;
    }

    public List<Tour> getTours() {
        return tours;
    }
}