/**
 * 
 */
package com.cheer.petStore3.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.cheer.petStore3.dao.MasterDao;
import com.cheer.petStore3.domain.Master;

public class MasterDaoImpl implements MasterDao
{

	
	private Session session;
	private Transaction tx;

    @Override
    public void save(Master master, Session session, Transaction tx)
    {
        session.save(master);
        session.flush();
        tx.commit();
    }

    @Override
    public int findMaster(Master master, Session session, Transaction tx)
    {
        if (master == null)
        {
            return 0;
        }
        String hql = "select m from Master m where m.username = :username and m.password = :password";
        Master m = session.createQuery(hql, Master.class).setParameter("username",
            master.getUsername()).setParameter("password", master.getPassword()).getSingleResult();

        if (m == null)
        {
            return 0;
        }

        return 1;
    }


}