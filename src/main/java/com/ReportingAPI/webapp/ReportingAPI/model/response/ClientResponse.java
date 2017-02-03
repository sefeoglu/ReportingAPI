package com.ReportingAPI.webapp.ReportingAPI.model.response;





import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientResponse {

    @JsonProperty("customerInfo")
    private CustomerInfo customerInfo;

    public ClientResponse() {
        super();
    }
    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }
}
