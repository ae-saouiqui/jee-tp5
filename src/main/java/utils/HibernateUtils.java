package utils;

import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtils {

    private static SessionFactory factory;

    static {

        ServiceRegistry registry = null;

        try {
            registry = new StandardServiceRegistryBuilder().configure().build();
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
            factory = metadata.getSessionFactoryBuilder().build();

        } catch (Exception e) {
            if (registry != null) {
                StandardServiceRegistryBuilder.destroy(registry);
            }
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}