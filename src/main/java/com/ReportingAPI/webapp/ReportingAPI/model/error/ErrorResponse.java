package com.ReportingAPI.webapp.ReportingAPI.model.error;




import java.util.List;


public class ErrorResponse {

    private List<BaseError> errors;

    public ErrorResponse() {
        super();
    }

    public ErrorResponse(List<BaseError> errors) {
        this.errors = errors;
    }
    public List<BaseError> getErrors() {
        return errors;
    }

    public void setErrors(List<BaseError> errors) {
        this.errors = errors;
    }
}
