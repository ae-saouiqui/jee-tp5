package services;

import entities.User;

public interface UserService {
    public User login(String username,String password);
}
