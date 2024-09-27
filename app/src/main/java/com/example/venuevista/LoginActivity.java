package com.example.venuevista;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;


import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView signupLink;
    private TextView logoText; // Add a reference for the logo TextView
    private ImageView togglepassword;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        signupLink = findViewById(R.id.signup_link);
        logoText = findViewById(R.id.logo_text); // Initialize logoText
        togglepassword = findViewById(R.id.toggle_password);

        togglepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPasswordVisible) {
                    //for hide password
                    passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    togglepassword.setImageResource(R.drawable.baseline_visibility_off_24);

                }else {
                    passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    togglepassword.setImageResource(R.drawable.baseline_visibility_24);

                }
                isPasswordVisible = !isPasswordVisible;
                //to have cursor in the end of text
                passwordEditText.setSelection(passwordEditText.getText().length());
            }
        });

        // Create a LinearGradient for the text
        Shader shader = new LinearGradient(0, 0, 0, logoText.getTextSize(),
                getResources().getColor(R.color.blue),
                getResources().getColor(R.color.lightblue),
                Shader.TileMode.CLAMP);

        // Apply the shader to the TextView's paint
        logoText.getPaint().setShader(shader);
        logoText.setTextSize(50);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change the color
                loginButton.setBackgroundColor(getResources().getColor(R.color.blue));

                // Handle login logic here
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // To close the login and go to home
            }
        });

        signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}
