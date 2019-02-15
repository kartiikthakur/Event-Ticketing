// package us.team7pro.EventTicketsApp.DatabaseLoaders;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;
// import us.team7pro.EventTicketsApp.Models.User;
// import us.team7pro.EventTicketsApp.Repositories.UserRepository;
// import java.util.ArrayList;
// import java.util.List;

// @Component
// public class UserSeeder implements CommandLineRunner {
//     private UserRepository userRepository;

//     @Autowired
//     public UserSeeder(UserRepository userRepository){
//         this.userRepository = userRepository;
//     }

//     @Override
//     public void run(String... strings) throws Exception{
//         List<User> users =  new ArrayList<>();

//         int a[] = {1,2,3};
//         int b[] = {4,5,6};
//         int c[] = {7,8,9};

//         users.add(new User("User", "test1", "password1", "test1@gmail.com", a));
//         users.add(new User("Admin", "test2", "password2", "test2@gmail.com", b));
//         users.add(new User("Organizer", "test3", "password3", "test3@gmail.com", c));


//         userRepository.saveAll(users);

//     }


// }