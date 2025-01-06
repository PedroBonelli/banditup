package br.com.sands.banditup.banditup.services.UserService.repository;

import br.com.sands.banditup.banditup.services.UserService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
