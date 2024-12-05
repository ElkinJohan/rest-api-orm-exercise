package com.elkin.restapiorm;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ORM API", version = "1.0", description = "Exercise ORM Information"))
public class RestApiOrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiOrmApplication.class, args);
	}

}
