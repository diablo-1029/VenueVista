package com.example.venuevista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private EditText searchBar;
    private ImageButton profileButton;
    private ImageButton homeIcon;
    private ImageButton calendarIcon;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize all the views
        searchBar = findViewById(R.id.search_bar);
        profileButton = findViewById(R.id.profile_button);
        homeIcon = findViewById(R.id.home_icon);
        calendarIcon = findViewById(R.id.calendar_icon);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);

        // Set tags for images to identify package types
        image1.setTag("outing");
        image2.setTag("birthday");
        image3.setTag("wedding");
        image4.setTag("corporate");
        image5.setTag("concert");
        image6.setTag("party");

        // Set click listener for images
        View.OnClickListener imageClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SelectPackageActivity.class);
                intent.putExtra("package_type", (String) view.getTag());
                startActivity(intent);
            }
        };

        image1.setOnClickListener(imageClickListener);
        image2.setOnClickListener(imageClickListener);
        image3.setOnClickListener(imageClickListener);
        image4.setOnClickListener(imageClickListener);
        image5.setOnClickListener(imageClickListener);
        image6.setOnClickListener(imageClickListener);

        // Set click listener for search bar
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for profile button
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainProfileActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for calendar icon
        calendarIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, BookingActivity.class);
                startActivity(intent);
            }
        });
    }
}
