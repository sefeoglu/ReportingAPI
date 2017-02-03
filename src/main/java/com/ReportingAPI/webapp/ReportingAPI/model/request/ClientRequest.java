package com.ReportingAPI.webapp.ReportingAPI.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientRequest {

    @NotEmpty
    private String transactionId;

    public ClientRequest() {
        super();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "transactionId='" + transactionId + '\'' +
                '}';
    }
}
