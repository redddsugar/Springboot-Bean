package com.ln.config;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    /**
     * 数据源
     * @return
     */
    @Bean(name = "DatasourceOne")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.one")
    DataSource dsOne(){

        System.out.println("我是数据源1");
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "DatasourceTwo")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    DataSource dsTwo(){
        System.out.println("我是数据源2");
        return DruidDataSourceBuilder.create().build();

    }
}
