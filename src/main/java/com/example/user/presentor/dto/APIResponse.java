package com.example.user.presentor.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public record APIResponse(String error_code, String message, Object result) {
    public static APIResponse success() {
        return new APIResponse("success", "success", null);
    }

    public static APIResponse success(Object result) {
        return new APIResponse("success", "success", result);
    }
}
