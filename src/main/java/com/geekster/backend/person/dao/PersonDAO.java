package com.geekster.backend.person.dao;

import java.util.List;

import com.geekster.backend.person.PersonBean;


public interface PersonDAO {
	/**
	 * saves a Person in the database
	 * @param p
	 */
	public void add(PersonBean person);

	/**
	 *
	 * @return the list of existing Persons
	 */
	public List<PersonBean> find();
}