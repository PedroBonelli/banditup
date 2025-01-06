package br.com.sands.banditup.banditup.services.AuthenticationService.connection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "sands.banditup")
public class SpotifyAppConfiguration extends AppConfiguration {

    private String clientId;
    private String clientSecret;
    private String callbackURL;
    private final String baseURL = "https://accounts.spotify.com";

}
