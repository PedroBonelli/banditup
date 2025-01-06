package br.com.sands.banditup.banditup.services.UserService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "streaming_service_accounts")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class StreamingServiceAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Enumerated(EnumType.STRING)
    protected ConnectionStatus connectionStatus;
    protected LocalDate registryDate;

    @OneToOne
    @JoinColumn(name = "connection_data_id", referencedColumnName = "id")
    protected ConnectionData connectionData;

    public StreamingServiceAccount(){
        this.connectionStatus = ConnectionStatus.NOT_CONNECTED;
        this.registryDate = LocalDate.now();
    }



}
