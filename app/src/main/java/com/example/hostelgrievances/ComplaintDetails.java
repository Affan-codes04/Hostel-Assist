package com.example.hostelgrievances;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ComplaintDetails extends AppCompatActivity {

    public TextView textViewName, textViewRoomNumber, textViewIssue;
    public RadioGroup status;
    public RadioButton selectedButton;
    String name, room, issue, currentStatus;
    public Button submit;
    public int complaintType;
    public String registerNumber;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Complaints");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        textViewName = findViewById(R.id.name);
        textViewRoomNumber = findViewById(R.id.room);
        textViewIssue = findViewById(R.id.issue);
        status = findViewById(R.id.status);
        submit = findViewById(R.id.submit);

        name = getIntent().getStringExtra("Name");
        room = getIntent().getStringExtra("Room Number");
        issue = getIntent().getStringExtra("Issue");
        complaintType = getIntent().getIntExtra("Type", 0);
        registerNumber = getIntent().getStringExtra("Register Number");

        textViewName.setText(name);
        textViewRoomNumber.setText(room);
        textViewIssue.setText(issue);
    }

    public void getStatus() {
        int id = status.getCheckedRadioButtonId();
        selectedButton = findViewById(id);
        currentStatus = selectedButton.getText().toString();
    }

    public void statusUpdate(View v) {
        getStatus();
        if (complaintType == 1) {
            firebaseInsert("Electricity Issue");
        } else if (complaintType == 2) {
            firebaseInsert("WiFi Issue");
        } else if (complaintType == 3) {
            firebaseInsert("Carpentry Issue");
        } else {
            firebaseInsert("Water Issue");
        }
    }

    public void firebaseInsert(String complaintType) {
        DatabaseReference df = FirebaseDatabase.getInstance().getReference(complaintType).child(registerNumber);
        ModelWarden m = new ModelWarden(name, room, issue, registerNumber, currentStatus);

        df.setValue(m).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Complaint Status updated Successfully!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Failed to update complaint status! Please try again...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
