package com.shopping.prac.configuration;

import com.shopping.prac.aop.RepositoryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    RepositoryHandler getRepositoryHandler() {
        return new RepositoryHandler();
    }
}
