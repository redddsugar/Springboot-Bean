package com.ln.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.ln.daoOne",entityManagerFactoryRef = "localConnectionFactoryBean",transactionManagerRef = "platformTransactionManager")
public class JpaTwoConfig {


    @Autowired
    @Qualifier("DatasourceTwo")
    DataSource dsTwo;


    @Autowired
    JpaProperties jpaProperties;

    @Bean
    @Primary
    LocalContainerEntityManagerFactoryBean localConnectionFactoryBean(EntityManagerFactoryBuilder builder) {
        System.out.println("build数据源2");
        return builder.dataSource(dsTwo)
                .properties(jpaProperties.getProperties())
                .persistenceUnit("pu1")
                .packages("com.ln.entity")
                .build();
    }

    // 事务
    @Bean
    PlatformTransactionManager platformTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(localConnectionFactoryBean(builder).getObject());
    }
}
