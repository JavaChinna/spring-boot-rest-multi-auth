package com.javachinna.config;

public class Profiles {

	private Profiles() {
	}

	public static final String NO_AUTH = "noauth";
	public static final String BASIC_AUTH = "basicauth";
	public static final String JWT_AUTH = "jwtauth";
	public static final String LDAP_AUTH = "ldapauth";
	public static final String MULTI_AUTH = "multiauth";
}
