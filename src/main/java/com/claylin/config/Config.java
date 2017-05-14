package com.claylin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by claylin on 2017/5/9.
 */
@Configuration
@PropertySource({"classpath:mysql.properties","redis.properties","system.properties"})
public class Config {

    //To resolve ${} in @Value
    @Bean
    public PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
