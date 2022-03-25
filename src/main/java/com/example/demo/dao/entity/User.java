package com.example.demo.dao.entity;

import com.example.demo.controller.model.UserResponse;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class User {

    private Long id;
    private int age;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String mail;

    public  User() {
    }

    public User(int birth, String firstName, String lastName, String address, String phoneNumber, String mail) {
        this.age = birth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public UserResponse toDto() {
        UserResponse u = new UserResponse();
        u.setId(this.id);
        u.setBirth(this.age);
        u.setFirstName(this.firstName);
        u.setLastName(this.lastName);
        u.setAddress(this.address);
        u.setPhoneNumber(this.phoneNumber);
        u.setMail(this.mail);
        return u;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBirth() {
        return age;
    }

    public void setBirth(int birth) {
        this.age = birth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
