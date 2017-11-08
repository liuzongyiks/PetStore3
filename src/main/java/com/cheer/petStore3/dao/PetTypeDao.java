
package com.cheer.petStore3.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cheer.petStore3.domain.PetType;

public interface PetTypeDao
{
    void save(PetType petType, Session session, Transaction tx);

    List<PetType> findAllPetType(Session session, Transaction tx);
}