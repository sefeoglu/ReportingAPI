package com.ReportingAPI.webapp.ReportingAPI.model.request;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionRequest {
	 @NotEmpty
	 private String transactionId;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionRequest(String transactionId) {
		super();
		this.transactionId = transactionId;
	}

	public TransactionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	 

}
