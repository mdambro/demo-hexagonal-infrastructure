package com.mdambro.demo.infrastructure;

import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class InfrastructureApplication {

	@Generated
	public static void main(String[] args) {

		SpringApplication.run(InfrastructureApplication.class, args);

	}

}
