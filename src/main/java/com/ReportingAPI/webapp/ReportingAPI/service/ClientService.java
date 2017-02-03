package com.ReportingAPI.webapp.ReportingAPI.service;







import java.util.Optional;
import java.util.concurrent.Future;

import com.ReportingAPI.webapp.ReportingAPI.model.request.ClientRequest;
import com.ReportingAPI.webapp.ReportingAPI.model.response.ClientResponse;




public interface ClientService {

    Future<Optional<ClientResponse>> getClientDetails(ClientRequest request, String authorizationToken);

}
