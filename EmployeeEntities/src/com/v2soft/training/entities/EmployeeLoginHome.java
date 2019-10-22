package com.v2soft.training.entities;
// Generated Oct 16, 2019 11:18:55 AM by Hibernate Tools 5.1.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class EmployeeLogin.
 * @see com.v2soft.training.entities.EmployeeLogin
 * @author Hibernate Tools
 */
@Stateless
public class EmployeeLoginHome {

	private static final Log log = LogFactory.getLog(EmployeeLoginHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EmployeeLogin transientInstance) {
		log.debug("persisting EmployeeLogin instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(EmployeeLogin persistentInstance) {
		log.debug("removing EmployeeLogin instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public EmployeeLogin merge(EmployeeLogin detachedInstance) {
		log.debug("merging EmployeeLogin instance");
		try {
			EmployeeLogin result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EmployeeLogin findById(EmployeeLoginId id) {
		log.debug("getting EmployeeLogin instance with id: " + id);
		try {
			EmployeeLogin instance = entityManager.find(EmployeeLogin.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
