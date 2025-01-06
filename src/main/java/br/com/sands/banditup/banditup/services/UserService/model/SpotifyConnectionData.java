package br.com.sands.banditup.banditup.services.UserService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "SpotifyConnectionData")
@AllArgsConstructor
@NoArgsConstructor
public class SpotifyConnectionData extends ConnectionData {
    private String token_type;
    private int expires_in;
    private String refresh_token;
    private String scope;
}
