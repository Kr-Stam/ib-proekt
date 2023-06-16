package com.example.ibproekt.util;

public class UserExistsException extends Exception{
    @Override
    public String getMessage() {
        return "UserExistsException: " + super.getMessage();
    }
}
