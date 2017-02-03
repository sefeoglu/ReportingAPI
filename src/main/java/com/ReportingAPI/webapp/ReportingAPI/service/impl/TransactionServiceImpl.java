package com.ReportingAPI.webapp.ReportingAPI.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ReportingAPI.webapp.ReportingAPI.model.request.TransactionQueryRequest;
import com.ReportingAPI.webapp.ReportingAPI.model.request.TransactionRequest;
import com.ReportingAPI.webapp.ReportingAPI.model.request.TransactionsReportRequest;
import com.ReportingAPI.webapp.ReportingAPI.model.response.TransactionQueryResponse;
import com.ReportingAPI.webapp.ReportingAPI.model.response.TransactionResponse;
import com.ReportingAPI.webapp.ReportingAPI.model.response.TransactionsReportResponse;
import com.ReportingAPI.webapp.ReportingAPI.service.TransactionService;


@Service
public class TransactionServiceImpl implements TransactionService {

    private static final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

    
    private RestTemplate restTemplate = new RestTemplate();

    @Value("${baseUrl}")
    private String baseUrl;

    @Async
    @Override
    public TransactionsReportResponse reportTransactions(TransactionsReportRequest request, String authorizationToken) {

        String url = baseUrl + "/transaction/report";

        TransactionsReportResponse transactionsReportResponse = null;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationToken);

        HttpEntity entity = new HttpEntity(request,headers);
        try {
            log.info("Api call -> to : {}, with : {}", url, request);
            transactionsReportResponse = restTemplate.postForObject(url, entity, TransactionsReportResponse.class);
        } catch (RestClientException exception) {
            log.info("Api call failed -> status : {}, body : {}",exception.getCause(), exception.getMessage());
        }

        return transactionsReportResponse;
    }

    @Async
    @Override
    public TransactionQueryResponse queryTransactions(String authorizationToken,TransactionQueryRequest request) {
 
        String url = baseUrl + "/transaction/list";

        TransactionQueryResponse transactionQueryResponse = null;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationToken);

        HttpEntity entity = new HttpEntity(request,headers);
        try {
            transactionQueryResponse = restTemplate.postForObject(url, entity, TransactionQueryResponse.class);
        } catch (RestClientException exception) {
            
        }
        return transactionQueryResponse;
    }

	@Override
	public TransactionResponse getTransaction(String authorizationToken,
			String transactionid) {
		TransactionResponse transactionResponse = null;
		TransactionRequest request = new TransactionRequest();
		request.setTransactionId(transactionid);
		String url = baseUrl + "/transaction";
		 HttpHeaders headers = new HttpHeaders();
	     headers.set("Authorization", authorizationToken);
	     HttpEntity entity = new HttpEntity(request,headers);
	     try {
	            transactionResponse = restTemplate.postForObject(url, entity, TransactionResponse.class);
	        } catch (RestClientException exception) {
	            
	        }
		return transactionResponse;
	}
    

}
