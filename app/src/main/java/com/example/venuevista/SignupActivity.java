package com.example.venuevista;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
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

        // Add a TextWatcher to the password EditText to monitor changes
        signupPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No action needed before text is changed
            }

            @Override
            public void onTextChanged(CharSequence s, int position, int before, int count) {
                // Check password length as it's being typed
                if (s.length() < 8) {
                    showPasswordTooShortDialog(); // Show dialog if password is less than 8 characters
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // No action needed after text is changed
            }
        });

        // Sign-up for authentication/required
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String username = signupUsernameEditText.getText().toString().trim();
                String email = signupEmailEditText.getText().toString().trim();
                String password = signupPasswordEditText.getText().toString();
                String confirmPassword = signupConfirmPasswordEditText.getText().toString();

                // Validate the inputs
                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    showAlertDialog("All fields are required", "Please fill in all the fields.");
                } else if (!password.equals(confirmPassword)) {
                    showAlertDialog("Passwords do not match", "Please ensure both passwords match.");
                } else if (password.length() < 8) {
                    showAlertDialog("Password Too Short", "Password must be at least 8 characters long.");
                } else {
                    // Show a success message and navigate to the main screen
                    Toast.makeText(SignupActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
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

    // Method to show an alert dialog with a title and message
    private void showAlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Dismiss the dialog when "OK" is clicked
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // Method to show the dialog for passwords shorter than 8 characters
    private void showPasswordTooShortDialog() {
        showAlertDialog("Password Too Short", "Password must be at least 8 characters long.");
    }
}
