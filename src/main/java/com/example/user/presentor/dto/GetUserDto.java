package com.example.user.presentor.dto;

import jakarta.annotation.Nullable;

public class GetUserDto {
    @Nullable
    private Integer id;
    @Nullable
    private String email;

    public void setId(Integer id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email =  email;
    }

    public String getEmail() {return email;}
    public Integer getId() {return id;}
}
