package com.example.venuevista;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_signup);

        Button Loginbutton = findViewById(R.id.Login_button);

        Loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navigate back to login
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
