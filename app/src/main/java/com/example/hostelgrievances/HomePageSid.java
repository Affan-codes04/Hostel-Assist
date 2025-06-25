package com.example.hostelgrievances;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.appcompat.app.AppCompatActivity;

public class HomePageSid extends AppCompatActivity {

    CardView cardElectric;
    CardView cardwifi;
    CardView cardcarpentry;
    CardView cardwater;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardElectric = findViewById(R.id.cardElectric);
        cardwifi = findViewById(R.id.cardwifi);
        cardcarpentry = findViewById(R.id.cardcarpentry);
        cardwater = findViewById(R.id.cardwater);

        cardElectric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Electric Complaints clicked");
                Intent i = new Intent(getApplicationContext(),ElectricComplaints.class);
                startActivity(i);
            }
        });
        cardwifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Wifi Complaints clicked");
                Intent i = new Intent(getApplicationContext(),WiFiComplaints.class);
                startActivity(i);
            }
        });
        cardcarpentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Carpentry Complaints clicked");
                Intent i = new Intent(getApplicationContext(),CarpentryComplaints.class);
                startActivity(i);
            }
        });
        cardwater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Water Complaints clicked");
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
