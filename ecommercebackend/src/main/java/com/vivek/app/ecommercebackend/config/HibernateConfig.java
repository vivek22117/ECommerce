package com.vivek.app.ecommercebackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScan("com.vivek.app.ecommercebackend.dto")
public class HibernateConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource getDataSource(){
		BasicDataSource dataSource = new  BasicDataSource();
		
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory(){
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		
		factory.setDataSource(getDataSource());
		factory.setHibernateProperties(getProperties());
		factory.setPackagesToScan(new String[] {"com.vivek.app.ecommercebackend.dto"});
		
		return factory;
	}

	private Properties getProperties() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", env.getProperty("db.hibernate.dialect"));
		prop.setProperty("hibernate.hbm2ddl.auto", env.getProperty("db.action"));
		prop.setProperty("hibernate.show_sql", env.getProperty("db.hibernate.sql"));
		
		return prop;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(){
		HibernateTransactionManager transactionMngr = new HibernateTransactionManager();
		transactionMngr.setSessionFactory(getSessionFactory().getObject());
		return transactionMngr;
	}

}
