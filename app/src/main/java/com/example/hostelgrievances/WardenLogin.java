package com.example.hostelgrievances;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class WardenLogin extends AppCompatActivity {
    TextInputEditText username,password;
    String wardenUsername = "12345";
    String wardenPassword = "0987654321";
    String Username,Password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warden_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }
    public void retrieve(View v){
        Username = username.getText().toString();
        Password = password.getText().toString();

        if (Username.equals(wardenUsername)){
            if (Password.equals(wardenPassword)){
                Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),Warden_Page.class);
                startActivity(i);
            }
            else{
                Toast.makeText(getApplicationContext(),"Incorrect Password",Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"User not found",Toast.LENGTH_SHORT).show();
        }
    }
}