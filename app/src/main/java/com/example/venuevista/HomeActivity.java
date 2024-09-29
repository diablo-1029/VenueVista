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
    private ImageView image1;
    private ImageButton homeIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize all the views
        searchBar = findViewById(R.id.search_bar);
        profileButton = findViewById(R.id.profile_button);
        image1 = findViewById(R.id.image1);
        homeIcon =findViewById(R.id.home_icon);


        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Actions to click images
              Intent intent = new Intent(HomeActivity.this,SelectPackageActivity.class);
              startActivity(intent);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle profile button click
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
