package com.example.hostelgrievances;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class StudentPage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    String registerNumber;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_page);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        registerNumber = getIntent().getStringExtra("Register Number");

        // Load the default fragment (e.g., HomesFragment) on activity start
        loadFragment(new HomesFragment(registerNumber));

        // Set the listener for navigation item selection
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();

                if (itemId == R.id.grievance) {
                    selectedFragment = new HomesFragment(registerNumber);
                }
                // Uncomment and implement the other fragments as needed
                else if (itemId == R.id.service) {
                    selectedFragment = new RequestFragment();
                }
                /*else if (itemId == R.id.other) {
                    selectedFragment = new OtherFragment();
                }
                */

                if (selectedFragment != null) {
                    loadFragment(selectedFragment);
                    return true; // Return true to indicate that the item was selected
                }

                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Use replace to avoid fragment stacking
        fragmentTransaction.replace(R.id.container1, fragment);
        fragmentTransaction.commit();
    }
}
