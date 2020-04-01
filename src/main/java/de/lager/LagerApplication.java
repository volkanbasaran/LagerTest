package de.lager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "de.lager.repository")
@SpringBootApplication
public class LagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LagerApplication.class, args);
	}

}
