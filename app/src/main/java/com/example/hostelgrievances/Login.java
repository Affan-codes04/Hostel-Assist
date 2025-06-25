package com.example.hostelgrievances;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    public TextInputEditText email, password;
    public String Email, Password, registerNumber;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();

        // Check if user is already logged in
        /*SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);*/

/*        if (isLoggedIn) {
            // User is logged in, retrieve register number and redirect to StudentPage
            registerNumber = sharedPreferences.getString("registerNumber", null);
            Intent intent = new Intent(getApplicationContext(), StudentPage.class);
            intent.putExtra("Register Number", registerNumber);
            startActivity(intent);
            finish();
        }*/
    }

    public void login(View v) {
        Email = email.getText().toString().trim();
        Password = password.getText().toString().trim();

        if (Email.isEmpty() || Password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter email and password", Toast.LENGTH_SHORT).show();
            return;
        }

        // Sign in the user
        mAuth.signInWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();

                        if (user != null && user.isEmailVerified()) {
                            // Save login state and register number to SharedPreferences
                            SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("isLoggedIn", true);
                            editor.putString("registerNumber", registerNumber);
                            editor.apply();

                            // Redirect to Student Page
                            Intent intent = new Intent(getApplicationContext(), StudentPage.class);
                            intent.putExtra("Register Number", registerNumber);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Please verify your email before logging in.", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Authentication failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void redirect(View v) {
        // Navigate to registration screen
        Intent intent = new Intent(getApplicationContext(), StudentLogin.class);
        startActivity(intent);
    }
}
