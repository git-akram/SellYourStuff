package com.geekster.authentication;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class DefaultAuthenticationDAO implements AuthenticationDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public boolean validate(String user, String password) {
		final List<AuthenticationBean> userList = entityManager.createQuery("from AuthenticationBean").getResultList();
		for(final AuthenticationBean userInDb : userList){
			if(userInDb.getUsername().equals(user) && userInDb.getPassword().equals(password))
				return true;
		}
		return false;
	}

}
