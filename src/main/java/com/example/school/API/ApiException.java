package com.example.school.API;

public class ApiException extends RuntimeException {
    public ApiException(String massage){
        super(massage);
    }
}
