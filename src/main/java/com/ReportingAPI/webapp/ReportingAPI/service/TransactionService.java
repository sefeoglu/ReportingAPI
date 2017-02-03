package com.ReportingAPI.webapp.ReportingAPI.service;


import com.ReportingAPI.webapp.ReportingAPI.model.request.TransactionQueryRequest;
import com.ReportingAPI.webapp.ReportingAPI.model.request.TransactionsReportRequest;
import com.ReportingAPI.webapp.ReportingAPI.model.response.TransactionQueryResponse;
import com.ReportingAPI.webapp.ReportingAPI.model.response.TransactionResponse;
import com.ReportingAPI.webapp.ReportingAPI.model.response.TransactionsReportResponse;


public interface TransactionService {

  TransactionsReportResponse reportTransactions(TransactionsReportRequest request, String authorizationToken);

  TransactionQueryResponse queryTransactions(String authorizationToken, TransactionQueryRequest request);
  TransactionResponse getTransaction(String authorizationToken, String transactionid);
  

}
