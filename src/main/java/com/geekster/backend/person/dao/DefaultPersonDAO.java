package com.geekster.backend.person.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.geekster.backend.person.PersonBean;

@Repository
public class DefaultPersonDAO implements PersonDAO{

	private static final Logger logger = LoggerFactory.getLogger(DefaultPersonDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void add(PersonBean person) {
		entityManager.persist(person);
		logger.info("Person saved successfully, person Details="+person);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonBean> find() {
		return entityManager.createQuery("from PersonBean").getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}


}
