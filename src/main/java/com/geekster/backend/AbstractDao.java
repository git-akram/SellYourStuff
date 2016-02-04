package com.geekster.backend;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao<T> {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(T entity) {
		entityManager.persist(entity);
	}

	public T find(int id) {
		return entityManager.find(getEntityClass(), id);
	}

	public T update(T entity) {
		return entityManager.merge(entity);
	}

	public void remove(T entity) {
		entityManager.remove(entity);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	public Class<T> getEntityClass() {
		final ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}
}