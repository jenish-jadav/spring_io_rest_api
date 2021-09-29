package com.example.demo.models;

import java.util.List;

public class ApiResponse {

    private boolean isSuccess;
    private String message;
    //private List<String> errorMessages;

    public ApiResponse() {
        this.isSuccess = false;
        this.message = "";
    }

    public ApiResponse(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public ApiResponse(boolean isSuccess, String message,List<String> errorMessages) {
        this.isSuccess = isSuccess;
        this.message = message;
        //this.errorMessages=errorMessages;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // public List<String> getErrorMessages() {
    //     return errorMessages;
    // }

    // public void setErrorMessages(List<String> errorMessages) {
    //     this.errorMessages = errorMessages;
    // }

    public static ApiResponse SetSuccessResponse(String message) {
        return new ApiResponse(true, message);
    }

    public static ApiResponse SetErrorResponse(String message) {
        return new ApiResponse(false, message);
    }

    public static ApiResponse SetErrorResponse(List<String> errors) {
        return new ApiResponse(false,"Error", errors);
    }

}
