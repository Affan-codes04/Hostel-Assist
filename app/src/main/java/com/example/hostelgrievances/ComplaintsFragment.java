package com.example.hostelgrievances;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ComplaintsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ComplaintsAdapter adapter;
    private List<Complaint> complaintList;
    public int complaintType;

    public ComplaintsFragment(int complaintType) {
        this.complaintType = complaintType;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_complaints, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewComplaints);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        complaintList = new ArrayList<>();
        adapter = new ComplaintsAdapter(getContext(), complaintList, complaintType);
        recyclerView.setAdapter(adapter);

        if (complaintType == 1) {
            loadComplaintsFromFirebase("Electricity Issue");
        } else if (complaintType == 2) {
            loadComplaintsFromFirebase("WiFi Issue");
        } else if (complaintType == 3) {
            loadComplaintsFromFirebase("Carpentry Issue");
        } else {
            loadComplaintsFromFirebase("Water Issue");
        }

        return view;
    }

    private void loadComplaintsFromFirebase(String type) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(type);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                complaintList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Complaint complaint = snapshot.getValue(Complaint.class);
                    if (complaint != null) {
                        complaintList.add(complaint);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle potential errors
            }
        });
    }
}
