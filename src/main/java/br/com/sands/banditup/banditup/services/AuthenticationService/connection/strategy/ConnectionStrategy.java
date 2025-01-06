package br.com.sands.banditup.banditup.services.AuthenticationService.connection.strategy;

import br.com.sands.banditup.banditup.services.UserService.model.ConnectionData;
import br.com.sands.banditup.banditup.services.UserService.model.ConnectionInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

public interface ConnectionStrategy {

    public ConnectionData connect(ConnectionInput inputData, RestClient apiClient);

}
