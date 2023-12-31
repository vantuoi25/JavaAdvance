package com.vti.utils;

import com.vti.entity.Account;
import com.vti.entity.Address;
import com.vti.entity.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    private  static  HibernateUtils instance;

    private Configuration configuration;

    private SessionFactory sessionFactory;

    private  HibernateUtils() {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Group.class);

        //open connection MYSQL
        //openSession();
    }

    public static HibernateUtils getInstance() {
        if (instance == null) {
            instance = new HibernateUtils();
        }

        return instance;
    }

    private SessionFactory buildSessionFactory() {
        if (sessionFactory == null || sessionFactory.isClosed()) {

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }

    public Session openSession() {
        buildSessionFactory();
        return sessionFactory.openSession();
    }

    public void closeSession() {
        if (sessionFactory != null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }


}
