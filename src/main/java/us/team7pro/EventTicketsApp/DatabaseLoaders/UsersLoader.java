package us.team7pro.EventTicketsApp.DatabaseLoaders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import us.team7pro.EventTicketsApp.Domain.Role;
import us.team7pro.EventTicketsApp.Domain.User;
import us.team7pro.EventTicketsApp.SecurityRepo.RoleRepo;
import us.team7pro.EventTicketsApp.SecurityRepo.UserRepo;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class UsersLoader implements CommandLineRunner {

    private UserRepo userRepo;
    private RoleRepo roleRepo;

    public UsersLoader(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        /**
         * Add users and roles
         */
        addUsersAndRoles();
    }

    private void addUsersAndRoles() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String secret = "{bcrypt}" + encoder.encode("password");

        // Preset user roles
        Role userRole = new Role("ROLE_USER");
        roleRepo.save(userRole);
        Role adminRole = new Role("ROLE_ADMIN");
        roleRepo.save(adminRole);
        Role organizerRole = new Role("ROLE_ORGANIZER");
        roleRepo.save(organizerRole);

        User customer = new User("cus@gmail.com", secret, true);
        customer.addRole(userRole);
        userRepo.save(customer);

        User admin = new User("admin@gmail.com", secret, true);
        admin.addRole(adminRole);
        userRepo.save(admin);

        User organizer = new User("org@gmail.com", secret, true);
        organizer.addRole(organizerRole);
        userRepo.save(organizer);

        User master = new User("master@gmail.com", secret, true);
        master.addRoles(new HashSet<>(Arrays.asList(userRole, adminRole)));
        userRepo.save(master);

    }
}
