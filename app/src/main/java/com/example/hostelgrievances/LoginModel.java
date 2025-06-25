package com.example.hostelgrievances;

public class LoginModel {
    String reg,password;
    public LoginModel(){

    }
    public LoginModel(String reg,String password){
        this.reg = reg;
        this.password = password;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
