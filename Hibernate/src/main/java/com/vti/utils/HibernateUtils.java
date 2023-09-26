package com.vti.utils;

import com.vti.entity.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.imageio.spi.ServiceRegistry;

public class HibernateUtils {
    private static HibernateUtils instance;

    private Configuration configuration;

    private SessionFactory sessionFactory;


    public HibernateUtils() {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Group.class);
    }
    public static HibernateUtils getInstance(){
        if (instance == null){
            instance = new HibernateUtils();
        }
        return instance;
    }
    private SessionFactory buildSessionFatory(){
        if(sessionFactory == null || sessionFactory.isClosed()){
            ServiceRegistry serviceRegistry = (ServiceRegistry) new
                    StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        }
        return sessionFactory;
    }
    public Session openSession(){
        buildSessionFatory();
        return sessionFactory.openSession();
    }
    public void closeSession(){
        if(sessionFactory != null && sessionFactory.isOpen()){
            sessionFactory.close();
        }
    }
}
