package com.example.hostelgrievances;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ComplaintsAdapter extends RecyclerView.Adapter<ComplaintsAdapter.ComplaintsViewHolder> {

    private Context context;
    private List<Complaint> complaintList;
    public int complaintType;

    public ComplaintsAdapter(Context context, List<Complaint> complaintList, int complaintType) {
        this.context = context;
        this.complaintList = complaintList;
        this.complaintType = complaintType;
    }

    @NonNull
    @Override
    public ComplaintsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_complaint, parent, false);
        return new ComplaintsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComplaintsViewHolder holder, int position) {
        Complaint complaint = complaintList.get(position);

        holder.textViewRegisterNumber.setText(complaint.getName());
        holder.textViewRoomNumber.setText("Room Number: " + complaint.getRoom());
        holder.textViewComplaintDescription.setText(complaint.getIssue());

        holder.complaintImage.setImageResource(R.drawable.woman);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ComplaintDetails.class);
            intent.putExtra("Name", complaint.getName());
            intent.putExtra("Room Number", complaint.getRoom());
            intent.putExtra("Issue", complaint.getIssue());
            intent.putExtra("Type", complaintType);
            intent.putExtra("Register Number", complaint.getRegisterNumber());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return complaintList.size();
    }

    public static class ComplaintsViewHolder extends RecyclerView.ViewHolder {
        TextView textViewRegisterNumber;
        TextView textViewRoomNumber;
        TextView textViewComplaintDescription;
        ImageView complaintImage;

        public ComplaintsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewRegisterNumber = itemView.findViewById(R.id.textViewRegisterNumber);
            textViewRoomNumber = itemView.findViewById(R.id.textViewRoomNumber);
            textViewComplaintDescription = itemView.findViewById(R.id.textViewComplaintDescription);
            complaintImage = itemView.findViewById(R.id.complaintImage);
        }
    }
}
