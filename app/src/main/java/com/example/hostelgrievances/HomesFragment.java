package com.example.hostelgrievances;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class HomesFragment extends Fragment {
    CardView cardElectric;
    CardView cardwifi;
    CardView cardcarpentry;
    CardView cardwater;
    String registerNumber;

    public HomesFragment(String reg) {
        this.registerNumber = reg;
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homes, container, false);

        // Now find views using the inflated view
        cardElectric = view.findViewById(R.id.cardElectric);
        cardwifi = view.findViewById(R.id.cardwifi);
        cardcarpentry = view.findViewById(R.id.cardcarpentry);
        cardwater = view.findViewById(R.id.cardwater);

        // Set onClickListeners for each card
        cardElectric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Electric Complaints clicked");
                Intent i = new Intent(getContext(), ElectricComplaints.class);
                i.putExtra("Register Number",registerNumber);
                startActivity(i);
            }
        });

        cardwifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Wifi Complaints clicked");
                Intent i = new Intent(getContext(), WiFiComplaints.class);
                i.putExtra("Register Number",registerNumber);
                startActivity(i);
            }
        });

        cardcarpentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Carpentry Complaints clicked");
                Intent i = new Intent(getContext(), CarpentryComplaints.class);
                i.putExtra("Register Number",registerNumber);
                startActivity(i);
            }
        });

        cardwater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Water Complaints clicked");
                Intent i = new Intent(getContext(), MainActivity.class);
                i.putExtra("Register Number",registerNumber);
                startActivity(i);
            }
        });

        // Return the inflated view
        return view;
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
