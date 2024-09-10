package com.example.venuevista;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ImageView profilePicture;
    private TextView profileName;
    private Button editprofileButton;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_profile);

        profilePicture = findViewById(R.id.profile_picture);
        profileName = findViewById(R.id.profile_name);
        editprofileButton = findViewById(R.id.edit_profile_button);

        //add function to edit profile
        editprofileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //edit profile button click
                //ADD more activity here optional
            }
        });

    }

}
