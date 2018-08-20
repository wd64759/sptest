package com.jarta.cloud.cfg;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CfgApp {
	public static void main(String[] args) {
		SpringApplication.run(CfgApp.class, args);
	}
	
    @Bean(name="initStarter")
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
    
    @Bean(name="localDS")
    @ConfigurationProperties("local.datasource")
    public DataSource localDataSource() {
    	return DataSourceBuilder.create().build();
    }
    
    @Bean(name="remoteDB")
    @ConfigurationProperties("remote.datasource")
    public DataSource remoteDataSource() {
    	return DataSourceBuilder.create().build();
    }
}
