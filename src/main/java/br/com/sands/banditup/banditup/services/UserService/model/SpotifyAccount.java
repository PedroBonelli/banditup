package br.com.sands.banditup.banditup.services.UserService.model;

import br.com.sands.banditup.banditup.services.UserService.model.SpotifyEmbeddable.SpotifyFollowersObject;
import br.com.sands.banditup.banditup.services.UserService.model.SpotifyEmbeddable.SpotifyImageObject;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "SpotifyAccounts")
public class SpotifyAccount extends StreamingServiceAccount{

    @ElementCollection
    private List<SpotifyImageObject> images;
    private SpotifyFollowersObject followers;
    private String email;
    private String display_name;
    private String uri;

    public SpotifyAccount() {
    }

}
