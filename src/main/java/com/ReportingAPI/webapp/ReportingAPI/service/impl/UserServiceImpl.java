package com.ReportingAPI.webapp.ReportingAPI.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;







import com.ReportingAPI.webapp.ReportingAPI.model.request.Credential;
import com.ReportingAPI.webapp.ReportingAPI.model.response.AuthToken;
import com.ReportingAPI.webapp.ReportingAPI.service.UserService;

import java.util.Optional;
import java.util.concurrent.Future;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


    @Value("${baseUrl}")
    private String baseUrl;

    @Async
    @Override
    public AuthToken login(Credential credential) {
    	RestTemplate restTemplate =  new RestTemplate();
        String url = baseUrl + "/merchant/user/login";
        AuthToken authToken = null;
        try {
            authToken = restTemplate.postForObject(url, credential, AuthToken.class);
        } catch (RestClientException exception) {
        
        }

        return authToken;
    }
}
