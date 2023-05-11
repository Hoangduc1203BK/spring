package com.example.user.common.validator;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Validator {
    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        Pattern pattern = Pattern.compile(emailRegex);

        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        String emailRegex = ".*\\d{10}.*";

        Pattern pattern = Pattern.compile(emailRegex);

        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}
