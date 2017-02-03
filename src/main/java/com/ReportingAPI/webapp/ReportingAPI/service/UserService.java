package com.ReportingAPI.webapp.ReportingAPI.service;

import java.util.Optional;
import java.util.concurrent.Future;

import com.ReportingAPI.webapp.ReportingAPI.model.request.Credential;
import com.ReportingAPI.webapp.ReportingAPI.model.response.AuthToken;




public interface UserService {

    AuthToken login(Credential credential);

}
