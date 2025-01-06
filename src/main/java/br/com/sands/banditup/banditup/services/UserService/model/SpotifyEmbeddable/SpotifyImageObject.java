package br.com.sands.banditup.banditup.services.UserService.model.SpotifyEmbeddable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpotifyImageObject {

    private String url;
    private int height;
    private int width;

}
