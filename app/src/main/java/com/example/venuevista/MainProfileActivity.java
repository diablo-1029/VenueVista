package com.example.venuevista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainProfileActivity extends AppCompatActivity {

    private ImageButton proceedButton;
    private TextView logOut;
    private ImageButton homeIcon;
    private ImageButton calendarIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_main_profile);

        proceedButton = findViewById(R.id.proceed_button);
        logOut = findViewById(R.id.log_out);
        homeIcon = findViewById(R.id.home_icon);
        calendarIcon = findViewById(R.id.calendar_icon);

        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();  // Closes the current activity and returns to the previous one
            }
        });

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainProfileActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainProfileActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainProfileActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        calendarIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainProfileActivity.this,BookingActivity.class);
                startActivity(intent);
            }
        });
    }
}
