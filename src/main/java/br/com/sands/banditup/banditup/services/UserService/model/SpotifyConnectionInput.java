package br.com.sands.banditup.banditup.services.UserService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpotifyConnectionInput extends ConnectionInput{

    private String authorizationCode;
    private String redirect_uri;

}
