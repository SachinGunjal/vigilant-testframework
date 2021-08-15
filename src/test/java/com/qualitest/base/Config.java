package com.qualitest.base;

import com.qualitest.pages.BasePage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

/**
 * This class will hold all the beans(Page Objects) needed.
 */
@Configuration
@PropertySource("file:src/test/resources/env/env-${env:dev}.properties")
public class Config {

    @Bean
    @Scope("cucumber-glue")
    BasePage basePage() {
        return new BasePage();
    }
}
