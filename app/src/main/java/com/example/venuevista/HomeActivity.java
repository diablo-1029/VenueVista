package com.example.venuevista;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private EditText searchBar;
    private ImageButton profileButton;
    private TextView homeContent;
    private ScrollView scrollView;  // Declare the ScrollView


    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize all the views
        searchBar = findViewById(R.id.search_bar);
        profileButton = findViewById(R.id.profile_button);
        homeContent = findViewById(R.id.home_content);

        // Initialize the ScrollView
        scrollView = findViewById(R.id.scroll_view);

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
