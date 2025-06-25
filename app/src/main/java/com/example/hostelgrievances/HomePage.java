package com.example.hostelgrievances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();  // Clear login state
        editor.apply();

/*
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

        if (isLoggedIn) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }*/
    }
    public void studentLogin(View v){
        Intent i = new Intent(this,StudentLogin.class);
        startActivity(i);
        finish();
    }
    public void wardenLogin(View v){
        Intent i = new Intent(this,WardenLogin.class);
        startActivity(i);
    }
}