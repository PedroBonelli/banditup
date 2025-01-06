package br.com.sands.banditup.banditup.services.UserService.model.SpotifyEmbeddable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpotifyFollowersObject {

    private String href;
    private int total;

}
