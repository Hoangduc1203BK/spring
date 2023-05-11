package com.example.user.presentor.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("password")
public class UserModel {

    private Integer id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private Long balance;
    public Integer getId() {return id;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getPassword() {return password;}
    public Long getBalance() {return balance;}

    public void setId(Integer id) {this.id =id;}
    public void setName(String name) {this.name =name;}
    public void setEmail(String email) {this.email =email;}
    public void setPassword(String password) {this.password =password;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber =phoneNumber;}
    public void setBalance(Long balance) {this.balance = balance;}
}
