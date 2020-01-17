package dev.config;

import java.util.Scanner;

import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//Le stéréotype @Configuration précise que cette classe servira de configuration.
@Configuration
@ComponentScan("dev")
@PropertySource("application.properties")
//@Import(DataSourceMySQLConfig.class)
//@Import(JpaConfig.class)
@EnableJpaRepositories("dev.repository")
public class AppConfig {

	@Bean
	public Scanner scanner () {
		return new Scanner(System.in);
	}
}
