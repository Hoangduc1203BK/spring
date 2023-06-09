package com.example.user.presentor.dto;


import jakarta.validation.constraints.*;

public class CreateUserDto {
//    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private String phoneNumber;
    @NotNull
    private Long balance;
    public CreateUserDto(String name, String email, String phoneNumber, String password, Long balance) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.balance = balance;
    }
    public String getName() {return name; }
    public String getEmail() {return email;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getPassword() {return password;}
    public Long getBalance() {return balance;}
}
