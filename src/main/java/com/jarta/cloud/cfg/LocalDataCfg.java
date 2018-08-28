package com.jarta.cloud.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef="localEntityFactory",
		transactionManagerRef="localTransactionManager",
		basePackages="com.jarta.cloud.data")
public class LocalDataCfg {
	
	@Autowired @Qualifier("localDS")
	private DataSource dataSource;

	@Primary
	@Bean("localEntityFactory")
	public LocalContainerEntityManagerFactoryBean localEntityFactory(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(dataSource)
				.packages("com.jarta.cloud.data.entities")
				.build();
	}
	
	@Primary
	@Bean("localTransactionManager")
	public PlatformTransactionManager localTransactionManager(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(localEntityFactory(builder).getObject());
	}
}
