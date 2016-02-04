package com.geekster.backend.authentication.service;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekster.backend.authentication.AuthenticationBean;
import com.geekster.backend.authentication.AuthenticationEnum;
import com.geekster.backend.authentication.SessionBean;
import com.geekster.backend.authentication.dao.AuthenticationDAO;

@Service
@SessionScoped
public class DefaultAuthenticationService implements AuthenticationService {

	@Autowired
	AuthenticationDAO authenticationDAO;

	@Override
	@Transactional
	public String login(AuthenticationBean user) {
		final boolean valid = authenticationDAO.validate(user.getUsername(), user.getPassword());
		if (valid) {
			final HttpSession session = SessionBean.getSession();
			session.setAttribute("username", user.getUsername());
			return AuthenticationEnum.AUTORIZED.getValue();
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return AuthenticationEnum.LOGIN.getValue();
		}

	}

	@Override
	@Transactional
	public String logout() {
		final HttpSession session = SessionBean.getSession();
		session.invalidate();
		return "login";

	}

	public AuthenticationDAO getAuthenticationDAO() {
		return authenticationDAO;
	}

	public void setAuthenticationDAO(AuthenticationDAO authenticationDao) {
		this.authenticationDAO = authenticationDao;
	}



}
