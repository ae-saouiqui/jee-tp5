package dao;

import entities.User;

public class UserDAOImpl extends BaseDAO implements UserDAO{

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        session = factory.getCurrentSession();
        String query = "FROM User WHERE username= :u AND password= :p";
        User user = (User) session.createQuery(query)
        .setParameter("u", username)
        .setParameter("p", password)
        .uniqueResult();
        return user;
    }
}
