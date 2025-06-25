package com.example.hostelgrievances;

public class ModelWarden {
    // Making fields public or providing getters and setters
    public String name;
    public String room;
    public String issue;
    public String registerNumber;
    public String status;

    // Public no-argument constructor required for Firebase
    public ModelWarden() {
    }

    public ModelWarden(String name, String room, String issue,String registerNumber,String status) {
        this.name = name;
        this.room = room;
        this.issue = issue;
        this.registerNumber = registerNumber;
        this.status = status;
    }

    // Getters and setters
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
