package com.example.hostelgrievances;

public class Complaint {
    private String name;
    private String room;
    private String issue;
    public String registerNumber;

    public Complaint() {
        // Default constructor required for calls to DataSnapshot.getValue(Complaint.class)
    }

    public Complaint(String name, String room,String issue, String registerNumber) {
        this.name = name;
        this.room = room;
        this.issue = issue;
        this.registerNumber = registerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }
}
