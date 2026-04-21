package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import utils.HibernateUtils;

public abstract class BaseDAO {
    protected Session session;
    protected  static SessionFactory factory;
    static {
        factory = HibernateUtils.getSessionFactory();
    }
}
