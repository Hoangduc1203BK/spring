package com.example.user.presentor.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

public class GetUserDto {
    @NotNull
    private Integer id;
    @NotNull
    private String email;
    @NotNull
    private String phoneNumber;

    public void setId(Integer id) {this.id = id;}
    public void setEmail(String email) {
        this.email =  email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber =  phoneNumber;
    }

    public String getEmail() {return email;}
    public Integer getId() {return id;}
    public String getPhoneNumber() { return phoneNumber;}
}
