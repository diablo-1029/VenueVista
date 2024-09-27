package com.example.venuevista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private EditText searchBar;
    private ImageButton profileButton;
    private TextView homeContent;
    private ScrollView scrollView;
    private ImageView image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize all the views
        searchBar = findViewById(R.id.search_bar);
        profileButton = findViewById(R.id.profile_button);
        homeContent = findViewById(R.id.home_content);
        scrollView = findViewById(R.id.scroll_view);
        image1 = findViewById(R.id.image1);

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

        // ScrollView section
        // Optionally, scroll programmatically to a specific position
        scrollView.post(() -> {
            scrollView.scrollTo(0, 0);  // Scroll to the top (or any position you want)
        });
    }
}
