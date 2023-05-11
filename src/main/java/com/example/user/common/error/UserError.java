package com.example.user.common.error;

import com.example.user.common.BussinessException;

public class UserError {
    public static class InvalidEmail extends BussinessException {
        public InvalidEmail() {
            super("Invalid email");
        }
    }

    public static class InvalidPhoneNumber extends BussinessException {
        public InvalidPhoneNumber(String phoneNumber) {
            super("Invalid phone number:" +phoneNumber );
        }
    }

    public static class EmailExist extends BussinessException {
        public EmailExist(String email) {
            super("Email "+email+ " already exist");
        }
    }
    public static class BalanceNotBeNegative extends BussinessException {
        public BalanceNotBeNegative(Long balance) {
            super("Balance not negative");
        }
    }
    public static class UserNotFound extends BussinessException {
        public UserNotFound() {
            super("User not found");
        }
    }
}
