package com.example.venuevista;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ImageButton profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // Fixed parameter name
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView backButton = findViewById(R.id.back_button);
        profileButton = findViewById(R.id.profile_button);  // Initialize the profileButton

        // Add function to edit profile
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Edit profile button click
                // ADD more activity here optional
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();  // Closes the current activity and returns to the previous one
            }
        });
    }
}
