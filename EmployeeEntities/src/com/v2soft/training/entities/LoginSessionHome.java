package com.v2soft.training.entities;
// Generated Oct 16, 2019 11:18:55 AM by Hibernate Tools 5.1.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class LoginSession.
 * @see com.v2soft.training.entities.LoginSession
 * @author Hibernate Tools
 */
@Stateless
public class LoginSessionHome {

	private static final Log log = LogFactory.getLog(LoginSessionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(LoginSession transientInstance) {
		log.debug("persisting LoginSession instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(LoginSession persistentInstance) {
		log.debug("removing LoginSession instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public LoginSession merge(LoginSession detachedInstance) {
		log.debug("merging LoginSession instance");
		try {
			LoginSession result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LoginSession findById(LoginSessionId id) {
		log.debug("getting LoginSession instance with id: " + id);
		try {
			LoginSession instance = entityManager.find(LoginSession.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
