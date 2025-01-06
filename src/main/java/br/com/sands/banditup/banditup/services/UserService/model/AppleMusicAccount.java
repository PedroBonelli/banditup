package br.com.sands.banditup.banditup.services.UserService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AppleMusicAccounts")
@Getter
@Setter
public class AppleMusicAccount extends StreamingServiceAccount{

    @NotBlank
    private String email;

    public AppleMusicAccount(String email){
        this.email = email;
    }


}
