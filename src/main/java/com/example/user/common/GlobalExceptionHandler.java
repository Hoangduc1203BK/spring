package com.example.user.common;

import com.example.user.presentor.dto.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {BussinessException.class})
    public ResponseEntity<APIResponse> handleBussinessException(Exception exception) {
        return new ResponseEntity<>(new APIResponse("BUSINESS_EXCEPTION", exception.getMessage(), null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    ResponseEntity<APIResponse> handleSystemException(Exception exception) {
        System.out.println(exception.getMessage());
        String message = "Bạn hãy vui lòng thử lại. Nếu vẫn không thành công, hay liên hệ CSKH theo hotline 19001009";
        return new ResponseEntity<>(new APIResponse("SYSTEM_EXCEPTION", message, null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
