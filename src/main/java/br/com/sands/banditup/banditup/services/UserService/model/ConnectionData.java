package br.com.sands.banditup.banditup.services.UserService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "StreamingServiceConnectionData")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class ConnectionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String token;
}
