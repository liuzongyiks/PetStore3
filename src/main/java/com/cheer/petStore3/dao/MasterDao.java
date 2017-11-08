
package com.cheer.petStore3.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cheer.petStore3.domain.Master;

public interface MasterDao
{
    int findMaster(Master master, Session session, Transaction tx);

    void save(Master master, Session session, Transaction tx);
}