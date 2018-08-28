package com.jarta.cloud.cfg;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceCfg {
	
    @Bean(name="localDS")
    @Primary
    @ConfigurationProperties(prefix="datasources.local")
    public DataSource localDataSource() {
    	return DataSourceBuilder.create().build();
    }
}
