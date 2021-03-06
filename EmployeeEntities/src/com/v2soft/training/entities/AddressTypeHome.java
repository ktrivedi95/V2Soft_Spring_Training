package com.v2soft.training.entities;
// Generated Oct 16, 2019 11:18:55 AM by Hibernate Tools 5.1.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class AddressType.
 * @see com.v2soft.training.entities.AddressType
 * @author Hibernate Tools
 */
@Stateless
public class AddressTypeHome {

	private static final Log log = LogFactory.getLog(AddressTypeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(AddressType transientInstance) {
		log.debug("persisting AddressType instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(AddressType persistentInstance) {
		log.debug("removing AddressType instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public AddressType merge(AddressType detachedInstance) {
		log.debug("merging AddressType instance");
		try {
			AddressType result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AddressType findById(int id) {
		log.debug("getting AddressType instance with id: " + id);
		try {
			AddressType instance = entityManager.find(AddressType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
