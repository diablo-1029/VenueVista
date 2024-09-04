package com.example.venuevista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button buttonButton = findViewById(R.id.button);
        TextView chooseTextView = findViewById(R.id.choose);
        TextView choose1TextView = findViewById(R.id.choose1);
        TextView choose2TextView = findViewById(R.id.choose2);
        TextView choose3TextView = findViewById(R.id.choose3);

        Button button = findViewById(R.id.button); // Make sure you have the correct button ID
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent); // This starts the LoginActivity
            }
        });


    }
}