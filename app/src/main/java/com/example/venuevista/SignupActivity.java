package com.example.venuevista;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;

public class SignupActivity extends AppCompatActivity {

    private EditText signupUsernameEditText;
    private EditText signupEmailEditText;
    private EditText signupPasswordEditText;
    private EditText signupConfirmPasswordEditText;
    private Button signupButton;
    private ImageView togglepassword;
    private ImageView toggleconfirmpassword;
    private boolean isPasswordVisible = false;
    private boolean isConfirmPasswordVisible = false;
    private TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupUsernameEditText = findViewById(R.id.signup_username);
        signupEmailEditText = findViewById(R.id.signup_email);
        signupPasswordEditText = findViewById(R.id.signup_password);
        signupConfirmPasswordEditText = findViewById(R.id.signup_confirm_password);
        signupButton = findViewById(R.id.signup_button);
        togglepassword = findViewById(R.id.toggle_password);
        toggleconfirmpassword = findViewById(R.id.toggle_confirm_password);
        loginLink = findViewById(R.id.login_link);

        // Toggle password visibility for password
        togglepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPasswordVisible) {
                    // Hide password
                    signupPasswordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    togglepassword.setImageResource(R.drawable.baseline_visibility_off_24);
                } else {
                    // Show password
                    signupPasswordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    togglepassword.setImageResource(R.drawable.baseline_visibility_24);
                }
                isPasswordVisible = !isPasswordVisible;
                signupPasswordEditText.setSelection(signupPasswordEditText.getText().length());
            }
        });

        // Toggle password visibility for confirm password
        toggleconfirmpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isConfirmPasswordVisible) {
                    // Hide password
                    signupConfirmPasswordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    toggleconfirmpassword.setImageResource(R.drawable.baseline_visibility_off_24);
                } else {
                    // Show password
                    signupConfirmPasswordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    toggleconfirmpassword.setImageResource(R.drawable.baseline_visibility_24);
                }
                isConfirmPasswordVisible = !isConfirmPasswordVisible;
                signupConfirmPasswordEditText.setSelection(signupConfirmPasswordEditText.getText().length());
            }
        });

        // Sign-up for authentication/required
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String username = signupUsernameEditText.getText().toString();
                String email = signupEmailEditText.getText().toString();
                String password = signupPasswordEditText.getText().toString();
                String confirmPassword = signupConfirmPasswordEditText.getText().toString();

                // Validate the inputs
                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    // Show a success message and navigate to the main screen
                    Toast.makeText(SignupActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Close signup and go to main activity
                }
            }
        });

        // Redirect to login screen
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
