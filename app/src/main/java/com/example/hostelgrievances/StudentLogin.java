package com.example.hostelgrievances;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentLogin extends AppCompatActivity {
    public TextInputEditText reg, name, email, password;
    public String Reg, Name, Email, Password;
    TextView redirection;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        reg = findViewById(R.id.registerNumber);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        redirection = findViewById(R.id.redirection);

        mAuth = FirebaseAuth.getInstance(); // Initialize FirebaseAuth

        redirection.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            finish();
        });
    }

    public void createAccount(View v) {
        Reg = reg.getText().toString().trim();
        Name = name.getText().toString().trim();
        Email = email.getText().toString().trim();
        Password = password.getText().toString().trim();

        if (Reg.isEmpty() || Name.isEmpty() || Email.isEmpty() || Password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create user with email and password using Firebase Authentication
        mAuth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Send verification email
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            user.sendEmailVerification()
                                    .addOnCompleteListener(verifyTask -> {
                                        if (verifyTask.isSuccessful()) {
                                            // If verification email sent, save user details to Firebase Realtime Database
                                            AccountModel am = new AccountModel(Reg, Name, Email, Password);
                                            DatabaseReference df = FirebaseDatabase.getInstance().getReference("Student Account");

                                            df.child(Reg).setValue(am).addOnCompleteListener(dbTask -> {
                                                if (dbTask.isSuccessful()) {

                                                    SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                                    editor.putString("registerNumber", Reg);
                                                    editor.apply();

                                                    Toast.makeText(getApplicationContext(), "Account created successfully! Please verify your email.", Toast.LENGTH_LONG).show();
                                                    Intent i = new Intent(getApplicationContext(), Login.class);
                                                    startActivity(i);
                                                    finish();
                                                } else {
                                                    Toast.makeText(getApplicationContext(), "Error occurred while saving data.", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Failed to send verification email. Please try again.", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    } else {
                        // Registration failed, show error message
                        Toast.makeText(getApplicationContext(), "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
