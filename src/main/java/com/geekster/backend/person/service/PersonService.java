package com.geekster.backend.person.service;

import java.util.List;

import com.geekster.backend.person.PersonBean;

public interface PersonService {
	/**
	 * saves a person
	 * @param person
	 */
	public void add(PersonBean person);

	/**
	 *
	 * @return the list of existing persons
	 */
	public List<PersonBean> find();

}
