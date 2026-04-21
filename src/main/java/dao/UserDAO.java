package dao;

import entities.User;

public interface UserDAO {
    public User findByUsernameAndPassword(String username,String password);
}
