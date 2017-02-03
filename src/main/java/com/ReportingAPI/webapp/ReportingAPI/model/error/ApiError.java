package com.ReportingAPI.webapp.ReportingAPI.model.error;




public class ApiError extends BaseError {

    private String message;

    public ApiError() {
        super();
        this.message = "Invalid request.";
    }

    public ApiError(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
