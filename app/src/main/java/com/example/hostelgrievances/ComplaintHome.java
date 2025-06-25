package com.example.hostelgrievances;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ComplaintHome extends Fragment {

    CardView cardElectric;
    CardView cardwifi;
    CardView cardcarpentry;
    CardView cardwater;

    public ComplaintHome() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_complaint_home, container, false);

        cardElectric = view.findViewById(R.id.cardElectric);
        cardwifi = view.findViewById(R.id.cardwifi);
        cardcarpentry = view.findViewById(R.id.cardcarpentry);
        cardwater = view.findViewById(R.id.cardwater);

        // Set onClickListeners for each card
        cardElectric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Electric Complaints clicked");
                loadFragment(new ComplaintsFragment(1));
            }
        });

        cardwifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Wifi Complaints clicked");
                loadFragment(new ComplaintsFragment(2));
            }
        });

        cardcarpentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Carpentry Complaints clicked");
                loadFragment(new ComplaintsFragment(3));
            }
        });

        cardwater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Water Complaints clicked");
                loadFragment(new ComplaintsFragment(4));
            }
        });


        return view;
    }
    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}