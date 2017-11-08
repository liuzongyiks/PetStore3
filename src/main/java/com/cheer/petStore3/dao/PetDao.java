
package com.cheer.petStore3.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cheer.petStore3.domain.Pet;

public interface PetDao
{
    void save(Pet pet, Session session, Transaction tx);

    void delete(Pet pet, Session session, Transaction tx);

    void update(Pet pet, Session session, Transaction tx);
}