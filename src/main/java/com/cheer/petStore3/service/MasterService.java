
package com.cheer.petStore3.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cheer.petStore3.domain.Master;

public interface MasterService
{
	boolean login(Master master, Session session, Transaction tx);

	boolean adoptPet(Session session, Transaction tx);
}