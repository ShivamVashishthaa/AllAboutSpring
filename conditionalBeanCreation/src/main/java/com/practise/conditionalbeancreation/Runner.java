package com.practise.conditionalbeancreation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Runner {

    @Bean
    public CommandLineRunner run(ApplicationContext context) {
        return args -> {
            System.out.println("\n=== Loaded Beans ===");
            String[] beans = context.getBeanDefinitionNames();
            for (String bean : beans) {
                if (bean.contains("Bean")) {
                    System.out.println(bean);
                }
            }
        };
    }
}
