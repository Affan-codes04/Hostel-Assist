package com.example.hostelgrievances;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Requests extends AppCompatActivity {

    CardView cardIllness;

    CardView cardmess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);

        cardIllness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Illness Feedback Form clicked");
                Intent i = new Intent(getApplicationContext(), IllnessRequest.class);
                startActivity(i);
            }
        });


        cardmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Mess change clicked");
                Intent i = new Intent(getApplicationContext(), MessRequest.class);
                startActivity(i);
            }
        });
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}