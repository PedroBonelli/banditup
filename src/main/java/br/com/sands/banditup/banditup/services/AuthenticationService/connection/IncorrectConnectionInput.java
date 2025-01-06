package br.com.sands.banditup.banditup.services.AuthenticationService.connection;

public class IncorrectConnectionInput extends RuntimeException {
    public IncorrectConnectionInput(String message) {
        super(message);
    }
}
