package com.ReportingAPI.webapp.ReportingAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ReportingAPI.webapp.ReportingAPI.model.request.Credential;
import com.ReportingAPI.webapp.ReportingAPI.model.request.TransactionQueryRequest;
import com.ReportingAPI.webapp.ReportingAPI.model.request.TransactionRequest;
import com.ReportingAPI.webapp.ReportingAPI.model.response.AuthToken;
import com.ReportingAPI.webapp.ReportingAPI.model.response.TransactionQueryResponse;
import com.ReportingAPI.webapp.ReportingAPI.service.UserService;

import java.util.Optional;

import javax.validation.Valid;



@RestController
public class LoginController {
	@Autowired
	private UserService userservice;
   
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
    	
        return new ModelAndView("login","credential", new Credential());
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView getLoginAuthorizationToken(@Valid @ModelAttribute("credential") Credential credential) {
    	AuthToken token = userservice.login(credential);
    	TransactionQueryRequest transaction = new TransactionQueryRequest();
    	TransactionQueryResponse transactionlist = new TransactionQueryResponse();
    	TransactionRequest transactionRequest = new TransactionRequest();
    	ModelAndView modelandview =  new ModelAndView();
    	modelandview.addObject("token", token);
    	modelandview.addObject("transactionlist", transactionlist);
    	modelandview.addObject("transaction", transaction);
    	modelandview.addObject("transactionRequest", transactionRequest);
    	modelandview.setViewName("transactionlist");
    	return modelandview;
    }

}
