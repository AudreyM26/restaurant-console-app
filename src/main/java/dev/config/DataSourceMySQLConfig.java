package dev.config;
import javax.sql.DataSource;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceMySQLConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		// TODO mettre à jour les informations de connexion à la base de données
		dataSource.setUrl("jdbc:mariadb://localhost:3306/restaurant-bdd");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
}