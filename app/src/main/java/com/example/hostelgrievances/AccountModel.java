package com.example.hostelgrievances;

public class AccountModel {
    String reg,name,email,password;
    public AccountModel(){

    }
    public AccountModel(String r,String n,String e,String p){
        reg = r;
        name = n;
        email = e;
        password = p;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
