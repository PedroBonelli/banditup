package br.com.sands.banditup.banditup.services.UserService.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Usuarios")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @OneToOne
    @JoinColumn(name = "third_party_account_id", referencedColumnName = "id")
    private StreamingServiceAccount thirdPartyAccount;
}
