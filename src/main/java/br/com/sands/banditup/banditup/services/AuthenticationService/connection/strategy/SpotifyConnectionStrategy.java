package br.com.sands.banditup.banditup.services.AuthenticationService.connection.strategy;

import br.com.sands.banditup.banditup.services.AuthenticationService.connection.IncorrectConnectionInput;
import br.com.sands.banditup.banditup.services.UserService.model.ConnectionData;
import br.com.sands.banditup.banditup.services.UserService.model.ConnectionInput;
import br.com.sands.banditup.banditup.services.UserService.model.SpotifyConnectionData;
import br.com.sands.banditup.banditup.services.UserService.model.SpotifyConnectionInput;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.RequestEntity.post;

@NoArgsConstructor
public class SpotifyConnectionStrategy implements ConnectionStrategy{

    public ConnectionData connect(ConnectionInput connectionInput, RestClient apiClient){

        if(connectionInput instanceof SpotifyConnectionInput){
            SpotifyConnectionInput spotifyConnectionInput = (SpotifyConnectionInput) connectionInput;

            Map<String, String> bodyAttributes = this.createBodyAttributes(spotifyConnectionInput);

            ResponseEntity<SpotifyConnectionData> responseData = apiClient.post()
                    .body(bodyAttributes)
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .headers(headers -> {
                        headers.add("Authorization", spotifyConnectionInput.getAuthorizationCode());
                        headers.add("Content-Type", "application/x-www-form-urlencoded");
                    })
                    .retrieve()
                    .toEntity(SpotifyConnectionData.class);
            return responseData.getBody();
        } else {
            throw new IncorrectConnectionInput("INPUT DE CONEXÃO INCORRETO");
        }

    }

    private Map<String, String> createBodyAttributes(SpotifyConnectionInput connectionInput){
        Map<String, String> bodyAttributes = new HashMap<String, String>();
        bodyAttributes.put("grant_type", "authorization_code");
        bodyAttributes.put("code", connectionInput.getAuthorizationCode());
        bodyAttributes.put("redirect_uri", connectionInput.getRedirect_uri());
        return bodyAttributes;
    }

}
