package com.geekster.backend.person.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekster.backend.person.PersonBean;
import com.geekster.backend.person.dao.PersonDAO;


@Service
@ManagedBean(name="personService")
@SessionScoped
public class DefaultPersonService implements PersonService {

	@Autowired
	private PersonDAO personDAO;

	@Override
	public void add(PersonBean p) {
		this.personDAO.add(p);
	}

	@Override
	public List<PersonBean> find() {
		return this.personDAO.find();
	}

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

}
