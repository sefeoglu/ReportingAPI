package com.ReportingAPI.webapp.ReportingAPI.model.error;




public class AuthorizationError extends BaseError {

    private String message;

    public AuthorizationError() {
        super();
        this.message = "Authorization failed.";
    }

    public AuthorizationError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
