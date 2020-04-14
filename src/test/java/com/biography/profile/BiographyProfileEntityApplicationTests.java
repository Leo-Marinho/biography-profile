package com.biography.profile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = {BiographyProfileApplication.class},
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@ContextConfiguration
public abstract class BiographyProfileEntityApplicationTests {

	@Test
	void contextLoads() {
	}

	@LocalServerPort
	protected int port;

	@Autowired
	protected TestRestTemplate restTemplate;
}
