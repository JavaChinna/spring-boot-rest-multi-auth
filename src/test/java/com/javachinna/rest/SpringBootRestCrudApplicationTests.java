package com.javachinna.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.javachinna.config.Profiles;

@SpringBootTest
@ActiveProfiles(Profiles.NO_AUTH)
class SpringBootRestCrudApplicationTests {

	@Test
	void contextLoads() {
	}

}
