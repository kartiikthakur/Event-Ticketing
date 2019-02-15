package us.team7pro.EventTicketsApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.team7pro.EventTicketsApp.Domain.User;
import us.team7pro.EventTicketsApp.Repositories.UserRepository;

@Service
public class UserServiceJpaImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }
}
