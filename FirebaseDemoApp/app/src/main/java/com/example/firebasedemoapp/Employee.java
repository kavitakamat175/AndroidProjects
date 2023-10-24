package com.example.firebasedemoapp;

public class Employee {
    private String ID;
    private String name;
    private String address;
    private String phno;

    public Employee() {
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getPhno() {
        return phno;
    }
}
