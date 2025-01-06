package br.com.sands.banditup.banditup.services.AuthenticationService.connection;

import br.com.sands.banditup.banditup.services.AuthenticationService.connection.strategy.SpotifyConnectionStrategy;
import br.com.sands.banditup.banditup.services.UserService.model.SpotifyConnectionInput;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/3rdPartyConnection")
public class ConnectionController {

    @Autowired
    private ConnectionService service;

    @GetMapping("/spotify")
    public void getSpotifyAuthorizationCode(HttpServletResponse response) throws IOException {
        String authURI = service.buildSpotifyAuthorizationCodeURIAsString();
        response.sendRedirect(authURI);
    }

    @GetMapping("/spotify/connectionInput")
    public ResponseEntity<String> getSpotifyConnectionInput(@RequestParam("authorization_code") String authorizationCode){
        service.setConnectionStrategy(new SpotifyConnectionStrategy());
        SpotifyConnectionInput connectionInput = new SpotifyConnectionInput(authorizationCode, service.getSpotifyAppConfiguration().getCallbackURL());
        service.connect(connectionInput);
    }





}
