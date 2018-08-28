# JPA with Multiple Datasources
Create dedecated JPA repository with specified datasource
``` java
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
```

__Be Aware Of__
> If you want to use HikariDataSource as your JPA datasource, you need to use __jdbc-url__ instead of url
``` yml
jdbc-url: jdbc:h2:~/test
username: sa
driver-class-name: org.h2.Driver
type: com.zaxxer.hikari.HikariDataSource
```

# Lambda in Java
## Annonymous Express
* WithoutArg 无参
``` java
new Thread(
	() -> System.out.println("...");
).start();
```
* WithArgs
``` java
Collections.sort(list, (s1, s2) -> {
	return s1.compare(s2);
});
```