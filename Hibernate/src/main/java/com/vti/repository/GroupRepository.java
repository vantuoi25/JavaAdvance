package com.vti.repository;

import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GroupRepository {
    private HibernateUtils hibernateUtils;
    public  GroupRepository(){
        hibernateUtils = HibernateUtils.getInstance();
    }
    public void createGroup(Group group){
        Session session = null;
        Transaction transaction = null;
        try{
            session = hibernateUtils.openSession();

            transaction = session.getTransaction();
            transaction.begin();
            session.save(group);
            transaction.commit();
        }finally{
            if(session != null){
                session.close();
            }
        }
    }


}

