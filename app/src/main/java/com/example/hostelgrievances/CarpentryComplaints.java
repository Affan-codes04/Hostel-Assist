package com.example.hostelgrievances;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CarpentryComplaints extends AppCompatActivity {
    // EditText name,room,issue;
    String Name,roomNum,Issue,registerNumber;
    TextInputEditText name,room,issue;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpentry_complaints);

        name = findViewById(R.id.name);
        room = findViewById(R.id.room);
        issue = findViewById(R.id.issue);
        registerNumber = getIntent().getStringExtra("Register Number");


/*
        DBClass db = new DBClass(this);
        db.insert("Affan","786","Water Leakage");
        db.insert("Afrah","236","Water Shortage");
        db.insert("Irfan","101","Water Dripping");

        ArrayList<Model> det = db.fetch();
        for (int i =0;i < det.size();i++){
            Log.d("DETAILS","ID: " + det.get(i).id + " Name: " + det.get(i).name + " Room: " + det.get(i).room + " Issue: " + det.get(i).issue);
        }
        //db.delete();

        db.close();*/
    }
    public void raise(View v){
        Button b = (Button) v;
        Name = name.getText().toString();
        roomNum = room.getText().toString();
        Issue = issue.getText().toString();

        DatabaseReference df = FirebaseDatabase.getInstance().getReference("Carpentry Issue").child(registerNumber);

        Model m = new Model(Name,roomNum,Issue,registerNumber);

        df.setValue(m).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Complaint raised Successfully!!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Failed to raise complaint! Please try again...",Toast.LENGTH_SHORT).show();
                }
            }
        });

/*
        DBClass db = new DBClass(this);
        db.insert(Name,roomNum,Issue);*/

/*        ArrayList<Model> det = db.fetch();
        for (int i =0;i < det.size();i++){
            Log.d("DETAILS","ID: " + det.get(i).id + " Name: " + det.get(i).name + " Room: " + det.get(i).room + " Issue: " + det.get(i).issue);
        }
        db.close();*/
    }
}