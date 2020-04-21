package com.spring.webapplication.app;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.webapplication.dao.HibernateConfig;
import com.spring.webapplication.service.json.SalaryJsonConverter;

@Configuration
@EnableWebMvc
@Import(HibernateConfig.class)
@ImportResource("classpath:application-core.xml")
@PropertySource({ "classpath:application.properties" })
@Order(2)
public class ApplicationConfig {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	
	@Bean(name = "salaryCacheManager")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("salaries");
    }

	@Bean
	@Primary
	public SessionFactory getSessionFactory() {
	    if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
	        throw new NullPointerException("factory is not a hibernate factory");
	    }
	    return entityManagerFactory.unwrap(SessionFactory.class);
	}
	
	@Bean
	public SalaryJsonConverter getSalaryJsonConverter() {
		
		return new SalaryJsonConverter();
	}
}
