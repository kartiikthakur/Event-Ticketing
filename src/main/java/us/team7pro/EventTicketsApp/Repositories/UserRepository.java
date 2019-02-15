package us.team7pro.EventTicketsApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import us.team7pro.EventTicketsApp.Domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findById(long id);
    public User findByEmail(String email);
}
