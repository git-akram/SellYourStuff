package com.geekster.backend.authentication.service;

import com.geekster.backend.authentication.AuthenticationBean;

public interface AuthenticationService {

	public String login(AuthenticationBean user);

	public String logout();

}
