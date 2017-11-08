package com.cheer.petStore3.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class DBHelper
{
    private static final DBHelper INSTANCE = new DBHelper();

    private SessionFactory sf;

    private Session session;

    private Transaction tx;

    private DBHelper()
    {
        // 创建SessionFactory
        sf = new MetadataSources(new StandardServiceRegistryBuilder().configure(
            "hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();

        // 获取Session
        session = sf.getCurrentSession();

        // 获取事务
        tx = session.beginTransaction();
    }

    public static DBHelper getInstance()
    {
        return INSTANCE;
    }

    public Session getSession()
    {
        return this.session;
    }
    
    public Transaction getTrnsaction() 
    {
        return this.tx;
    }

    public void closeSessionFactory()
    {
       this.sf.close();
    }
}