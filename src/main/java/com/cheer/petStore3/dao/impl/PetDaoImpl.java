/**
 * 
 */
package com.cheer.petStore3.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cheer.petStore3.dao.PetDao;
import com.cheer.petStore3.domain.Pet;

public class PetDaoImpl implements PetDao
{
    @Override
    public void save(Pet pet, Session session, Transaction tx)
    {
        session.persist(pet);
        session.flush();
        tx.commit();
    }

    @Override
    public void delete(Pet pet, Session session, Transaction tx)
    {
        session.delete(session.get(Pet.class, pet.getId()));
        session.flush();
        tx.commit();
    }

    @Override
    public void update(Pet pet, Session session, Transaction tx)
    {

    }

}
