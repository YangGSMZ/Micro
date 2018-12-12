package com.micro.hospital.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * 配置在application.properties中数据库的的driver，url，username，password
 */
@Configuration
@MapperScan("com.micro.hospital.dao")
public class DataSourceConfig {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(jdbcDriver);
        comboPooledDataSource.setJdbcUrl(jdbcUrl);
        comboPooledDataSource.setUser(jdbcUsername);
        comboPooledDataSource.setPassword(jdbcPassword);
        comboPooledDataSource.setMaxPoolSize(30);
        comboPooledDataSource.setMinPoolSize(3);
        comboPooledDataSource.setAutoCommitOnClose(false);
        comboPooledDataSource.setCheckoutTimeout(30000);
        comboPooledDataSource.setAcquireRetryAttempts(2);
        return comboPooledDataSource;
    }
}
