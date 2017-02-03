package com.ReportingAPI.webapp.ReportingAPI.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponse {

	@JsonProperty
	private  Fx fxResponce;
	
	@JsonProperty
	private CustomerInfo customerInfo;
	
	@JsonProperty
	private Merchant merchant;
	
	@JsonProperty
	private Acquirer acquirer;
	
	@JsonProperty
	private TransactionMerchant merchantTransaction;


	public Acquirer getAcquirer() {
		return acquirer;
	}


	public void setAcquirer(Acquirer acquirer) {
		this.acquirer = acquirer;
	}


	public Fx getFxResponce() {
		return fxResponce;
	}


	public void setFxResponce(Fx fxResponce) {
		this.fxResponce = fxResponce;
	}


	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}


	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}


	public Merchant getMerchant() {
		return merchant;
	}


	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}


	public TransactionMerchant getMerchantTransaction() {
		return merchantTransaction;
	}


	public void setMerchantTransaction(TransactionMerchant merchantTransaction) {
		this.merchantTransaction = merchantTransaction;
	}


	public TransactionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TransactionResponse(Fx fxResponce, CustomerInfo customerInfo,
			Merchant merchant, Acquirer acquirer,
			TransactionMerchant merchantTransaction) {
		super();
		this.fxResponce = fxResponce;
		this.customerInfo = customerInfo;
		this.merchant = merchant;
		this.acquirer = acquirer;
		this.merchantTransaction = merchantTransaction;
	}


	
	
	
}
