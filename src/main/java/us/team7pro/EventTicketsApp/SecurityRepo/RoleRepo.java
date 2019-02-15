package us.team7pro.EventTicketsApp.SecurityRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import us.team7pro.EventTicketsApp.Domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
}
