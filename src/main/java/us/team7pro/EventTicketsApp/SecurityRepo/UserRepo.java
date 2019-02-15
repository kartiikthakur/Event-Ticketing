package us.team7pro.EventTicketsApp.SecurityRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import us.team7pro.EventTicketsApp.Domain.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
