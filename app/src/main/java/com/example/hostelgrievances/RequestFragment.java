package com.example.hostelgrievances;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class RequestFragment extends Fragment {

    CardView cardIllness;

    CardView cardmess;

    public RequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_request, container, false);

/*        cardIllness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Illness Feedback Form clicked");
                Intent i = new Intent(getContext(), IllnessRequest.class);
                startActivity(i);
            }
        });*/


/*        cardmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Mess change clicked");
                Intent i = new Intent(getContext(), MessRequest.class);
                startActivity(i);
            }
        });*/

        return view;
    }
    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}