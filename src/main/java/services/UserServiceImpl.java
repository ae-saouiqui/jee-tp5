package services;

import dao.UserDAO;
import dao.UserDAOImpl;
import entities.User;

public class UserServiceImpl  implements UserService{
    private static UserDAO dao = new UserDAOImpl();

    @Override
    public User login(String username, String password) {
            User user = dao.findByUsernameAndPassword(username, password);
            return user;
}
}
