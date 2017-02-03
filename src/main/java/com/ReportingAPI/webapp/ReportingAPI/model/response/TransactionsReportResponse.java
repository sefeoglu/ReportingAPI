package com.ReportingAPI.webapp.ReportingAPI.model.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionsReportResponse {

    @JsonProperty
    private String status;

    @JsonProperty("response")
    private List<TransactionReport> transactionReportList;

    public TransactionsReportResponse() {
        super();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TransactionReport> getTransactionReportList() {
        return transactionReportList;
    }

    public void setTransactionReportList(List<TransactionReport> transactionReportList) {
        this.transactionReportList = transactionReportList;
    }
}
