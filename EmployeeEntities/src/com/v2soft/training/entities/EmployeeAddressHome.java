package com.v2soft.training.entities;
// Generated Oct 16, 2019 11:18:55 AM by Hibernate Tools 5.1.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class EmployeeAddress.
 * @see com.v2soft.training.entities.EmployeeAddress
 * @author Hibernate Tools
 */
@Stateless
public class EmployeeAddressHome {

	private static final Log log = LogFactory.getLog(EmployeeAddressHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EmployeeAddress transientInstance) {
		log.debug("persisting EmployeeAddress instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(EmployeeAddress persistentInstance) {
		log.debug("removing EmployeeAddress instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public EmployeeAddress merge(EmployeeAddress detachedInstance) {
		log.debug("merging EmployeeAddress instance");
		try {
			EmployeeAddress result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EmployeeAddress findById(EmployeeAddressId id) {
		log.debug("getting EmployeeAddress instance with id: " + id);
		try {
			EmployeeAddress instance = entityManager.find(EmployeeAddress.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
