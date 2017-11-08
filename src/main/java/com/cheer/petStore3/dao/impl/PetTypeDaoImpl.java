/**
 * 
 */
package com.cheer.petStore3.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.cheer.petStore3.dao.PetTypeDao;
import com.cheer.petStore3.domain.PetType;

public class PetTypeDaoImpl implements PetTypeDao
{

    @Override
    public void save(PetType petType, Session session, Transaction tx)
    {
        session.save(petType);
        session.flush();
        tx.commit();
    }

    @Override
    public List<PetType> findAllPetType(Session session, Transaction tx)
    {
        String hql = "select pt from PetType pt";
        List<PetType> petTypeList = session.createQuery(hql, PetType.class).getResultList();
        return petTypeList;
    }

}