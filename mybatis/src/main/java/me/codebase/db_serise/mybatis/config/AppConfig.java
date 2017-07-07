package me.codebase.db_serise.mybatis.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;


/**
 * Created by chendong on 2017/7/5.
 * <p>
 * application configuration
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("me.codebase.db_serise.mybatis")
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

    //    @Bean
    public SqlSessionFactory getSqlSessionFactory(@Autowired DataSource dataSource) throws IOException {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        configuration.addMappers("me.codebase.db_serise.mybatis.mappers");
        configuration.setDatabaseId("uem_octopus");
        return sqlSessionFactory;
    }

    @Bean
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

}
