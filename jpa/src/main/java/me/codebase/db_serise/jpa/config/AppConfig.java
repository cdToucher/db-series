package me.codebase.db_serise.jpa.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by chendong on 2017/7/7.
 */
@Configuration
@ComponentScan("me.codebase.db_serise.jpa")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    @Autowired
    public PropertySourcesPlaceholderConfigurer getHolder(org.springframework.core.env.Environment env) throws IOException {
        PropertySourcesPlaceholderConfigurer bean = new PropertySourcesPlaceholderConfigurer();
        bean.setIgnoreResourceNotFound(true);
        bean.setIgnoreUnresolvablePlaceholders(true);
        bean.setEnvironment(env);
        return bean;
    }

    @Bean
    public DataSource getDataSource(@Autowired org.springframework.core.env.Environment env) throws IOException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }

}
