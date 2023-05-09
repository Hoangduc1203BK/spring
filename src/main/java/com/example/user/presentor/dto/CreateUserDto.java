package com.example.user.presentor.dto;

public class CreateUserDto {
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private Long balance;
    public String getName() {return name; }
    public String getEmail() {return email;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getPassword() {return password;}
    public Long getBalance() {return balance;}
}
