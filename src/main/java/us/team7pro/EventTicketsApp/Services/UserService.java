package us.team7pro.EventTicketsApp.Services;

import us.team7pro.EventTicketsApp.Domain.User;

public interface UserService {
    User findById(long id);
}
