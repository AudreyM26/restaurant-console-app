package dev.config;

import java.util.Scanner;

import org.springframework.context.annotation.*;


//Le stéréotype @Configuration précise que cette classe servira de configuration.
@Configuration
@ComponentScan("dev")
@PropertySource("application.properties")
@Import(DataSourceMySQLConfig.class)

public class AppConfig {

	@Bean
	public Scanner scanner () {
		return new Scanner(System.in);
	}
}
