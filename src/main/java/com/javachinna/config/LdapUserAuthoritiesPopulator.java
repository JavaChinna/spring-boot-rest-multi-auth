package com.javachinna.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Component;

import com.javachinna.model.Role;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class LdapUserAuthoritiesPopulator implements LdapAuthoritiesPopulator {

	private final UserDetailsService userDetailsService;

	@Override
	public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userData, String username) {
		Collection<? extends GrantedAuthority> authorities = new HashSet<>();
		try {
			authorities = userDetailsService.loadUserByUsername(username).getAuthorities();
		} catch (Exception e) {
			log.warn("Unable to fetch the user authorities from the database. Assuming it is an external user, assigning default user role");
			authorities = Arrays.asList(new SimpleGrantedAuthority(Role.ROLE_USER));
		}
		return authorities;
	}
}