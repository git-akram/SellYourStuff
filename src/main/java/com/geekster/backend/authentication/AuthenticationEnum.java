package com.geekster.backend.authentication;

public enum AuthenticationEnum {
	AUTORIZED("authorized"),
	LOGIN("login");

	String value;

	private AuthenticationEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}





}
