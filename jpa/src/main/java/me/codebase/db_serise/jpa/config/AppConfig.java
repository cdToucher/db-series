package me.codebase.db_serise.jpa.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by chendong on 2017/7/7.
 */
@Configuration
@ComponentScan("me.codebase.db_serise.jpa")
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages = {"me.codebase.db_serise.jpa.repository"})
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

    @Bean("entityManagerFactory")
    @Autowired
    public static LocalContainerEntityManagerFactoryBean getJpaFactoryBean(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPackagesToScan("me.codebase.db_serise.jpa.entity");
        bean.setJpaVendorAdapter(getHibernateJpaVendorAdapter());
        return bean;
    }

    @Bean("transactionManager")
    @Autowired
    public static JpaTransactionManager getJpaTransactionManager(DataSource dataSource) {
        JpaTransactionManager bean = new JpaTransactionManager();
        bean.setDataSource(dataSource);
        return bean;
    }

    @Bean
    public static HibernateJpaVendorAdapter getHibernateJpaVendorAdapter() {
        HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
        bean.setShowSql(true);
        bean.setGenerateDdl(true);
        return bean;
    }


}
