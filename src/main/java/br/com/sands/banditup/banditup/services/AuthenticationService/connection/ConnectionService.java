package br.com.sands.banditup.banditup.services.AuthenticationService.connection;

import br.com.sands.banditup.banditup.services.AuthenticationService.connection.strategy.ConnectionStrategy;
import br.com.sands.banditup.banditup.services.AuthenticationService.connection.strategy.SpotifyConnectionStrategy;
import br.com.sands.banditup.banditup.services.UserService.model.*;
import br.com.sands.banditup.banditup.services.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ConnectionService {

    @Autowired
    private RestClient connectionClient;

    @Autowired
    private SpotifyAppConfiguration spotifyConfiguration;

    //@Autowired
    //private AppleMusicAppConfiguration appleconfiguration;

    @Autowired
    private UserRepository userRepository;

    private ConnectionStrategy strategy;

    private final String defaultScope = "user-read-private user-read-email";

    public void setConnectionStrategy(ConnectionStrategy strategy){
        this.strategy = strategy;
    }

    public SpotifyAppConfiguration getSpotifyAppConfiguration(){
        return this.spotifyConfiguration;
    }

    public String buildSpotifyAuthorizationCodeURIAsString(){
        URI authCodeUri = UriComponentsBuilder
                .fromUriString(spotifyConfiguration.getBaseURL())
                .path("authorize")
                .queryParam("client_id", "{client_id}")
                .queryParam("response_type", "{response_type}")
                .queryParam("redirect_uri", "{redirect_uri}")
                .queryParam("scope", "{scope}")
                .build(spotifyConfiguration.getClientId(), "code", spotifyConfiguration.getCallbackURL(), defaultScope);
        return authCodeUri.toString();
    }

    public void saveUserConnectionData(ConnectionData connectionData, Long userId){
        User user = userRepository.getReferenceById(userId);
        user.getThirdPartyAccount().setConnectionData(connectionData);
    }

    public ConnectionData connect(ConnectionInput connectionInput){
        return strategy.connect(connectionInput, this.connectionClient);
    }

}
