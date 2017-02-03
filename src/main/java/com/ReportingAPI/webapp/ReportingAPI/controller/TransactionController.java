package com.ReportingAPI.webapp.ReportingAPI.controller;

import java.util.concurrent.Callable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ReportingAPI.webapp.ReportingAPI.model.request.Credential;
import com.ReportingAPI.webapp.ReportingAPI.model.request.TransactionQueryRequest;
import com.ReportingAPI.webapp.ReportingAPI.model.request.TransactionRequest;
import com.ReportingAPI.webapp.ReportingAPI.model.response.AuthToken;
import com.ReportingAPI.webapp.ReportingAPI.model.response.TransactionMerchant;
import com.ReportingAPI.webapp.ReportingAPI.model.response.TransactionQueryResponse;
import com.ReportingAPI.webapp.ReportingAPI.model.response.TransactionResponse;
import com.ReportingAPI.webapp.ReportingAPI.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@RequestMapping(value = "transaction/list", method = RequestMethod.POST)
	public ModelAndView queryTransactions(
			@Valid @ModelAttribute("token") AuthToken authorization,
			@Valid @ModelAttribute("transaction") TransactionQueryRequest transactionqueryrequest,
			@Valid @ModelAttribute("transactionlist") TransactionQueryResponse transactionlistresponce) {
		if (authorization.getToken() == null) {
			return new ModelAndView("login", "credential", new Credential());
		}
		TransactionQueryResponse transactionQueryFuture = transactionService
				.queryTransactions(authorization.getToken(),
						transactionqueryrequest);
		TransactionQueryResponse transactionQueryResponse = transactionQueryFuture;
		transactionlistresponce = transactionQueryResponse;

		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("token", authorization);
		modelandview.addObject("transactionlist", transactionlistresponce);
		modelandview.addObject("transaction", transactionqueryrequest);
		modelandview.setViewName("transactionlist");
		return modelandview;
	}

	@RequestMapping(value = "transaction/list/{id}", method = RequestMethod.GET)
	public ModelAndView queryTransactions(
			@PathVariable("id") int page,
			@Valid @ModelAttribute("token") AuthToken authorization,
			@Valid @ModelAttribute("transaction") TransactionQueryRequest transactionqueryrequest,
			@Valid @ModelAttribute("transactionlist") TransactionQueryResponse transactionlistresponce) {
		if (authorization.getToken() == null) {
			return new ModelAndView("login", "credential", new Credential());
		}
		transactionqueryrequest.setPage(page);
		TransactionQueryResponse transactionQueryFuture = transactionService
				.queryTransactions(authorization.getToken(),
						transactionqueryrequest);
		TransactionQueryResponse transactionQueryResponse = transactionQueryFuture;
		transactionlistresponce = transactionQueryResponse;
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("token", authorization);
		modelandview.addObject("transactionlist", transactionlistresponce);
		modelandview.addObject("transaction", transactionqueryrequest);
		modelandview.setViewName("transactionlist");
		return modelandview;
	}

	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	public ModelAndView getTransactionDetail(
			@Valid @ModelAttribute("token") AuthToken authorization,
			@Valid TransactionRequest transaction) {
		System.out.println("Şefika");
		System.out.println(authorization.getToken());
		if (authorization.getToken() == null) {
			return new ModelAndView("login", "credential", new Credential());
		}
		TransactionResponse transactionResponse = transactionService
				.getTransaction(authorization.getToken(),
						transaction.getTransactionId());
		System.out.println(transactionResponse.getMerchantTransaction()
				.getTransactionId());
		return new ModelAndView("transaction", "transaction",
				transactionResponse);
	}

}
