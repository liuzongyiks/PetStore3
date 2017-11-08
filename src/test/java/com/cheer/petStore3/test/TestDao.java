package com.cheer.petStore3.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cheer.petStore3.dao.MasterDao;
import com.cheer.petStore3.dao.PetTypeDao;
import com.cheer.petStore3.dao.impl.MasterDaoImpl;
import com.cheer.petStore3.dao.impl.PetTypeDaoImpl;
import com.cheer.petStore3.domain.Master;
import com.cheer.petStore3.domain.PetType;
import com.cheer.petStore3.service.MasterService;
import com.cheer.petStore3.service.impl.MasterServiceImpl;

@SuppressWarnings("unused")
public class TestDao
{
    private static SessionFactory sf;

    private Session session;

    private Transaction tx;

    @BeforeClass
    public static void init()
    {
        // 创建SessionFactory
        sf = new MetadataSources(new StandardServiceRegistryBuilder().configure(
            "hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();
    }

    @AfterClass
    public static void destory()
    {
        // 关闭工厂
        sf.close();
    }

    @Before
    public void before()
    {
        // 获取Session
        session = sf.getCurrentSession();

        // 获取事务并开始
        tx = session.beginTransaction();  
    }

    @Test
    public void testSavePet()
    {
        PetTypeDao ptd = new PetTypeDaoImpl();
        PetType petType = new PetType("狗子");
        ptd.save(petType, session, tx);
        petType = new PetType("猫儿");
        ptd.save(petType, session, tx);
        petType = new PetType("QQ");
        ptd.save(petType, session, tx);
    }

    @Test
    public void testSaveMaster()
    {
        MasterDao md = new MasterDaoImpl();
        Master master = new Master("李香兰", "007");
        md.save(master, session, tx);
    }

    @Test
    public void testLogin()
    {
        Master master = new Master("李香兰", "007");
        Assert.assertEquals(true, new MasterServiceImpl().login(master, session, tx));
        
    }

    @Test
    public void testAdoptPet()
    {
        
		MasterService masterService = new MasterServiceImpl();
        //Assert.assertEquals(true, masterService.adoptPet(session, tx));
        
    }
}