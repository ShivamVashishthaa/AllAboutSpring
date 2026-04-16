package com.practise.conditionalbeancreation;

import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    // 1. @ConditionalOnProperty
    @Bean
    @ConditionalOnProperty(name = "feature.enabled", havingValue = "true")
    public String featureBean() {
        return "Feature Enabled Bean";
    }

    // 2. @ConditionalOnMissingBean
    @Bean
    @ConditionalOnMissingBean(name = "defaultBean")
    public String defaultBean() {
        return "Default Bean";
    }

    // 3. @ConditionalOnBean
    @Bean
    @ConditionalOnBean(name = "defaultBean")
    public String dependentBean() {
        return "Dependent on defaultBean";
    }

    // 4. @ConditionalOnClass
    @Bean
    @ConditionalOnClass(name = "java.sql.Connection")
    public String classBean() {
        return "Loaded because class exists";
    }

    // 5. @ConditionalOnMissingClass
    @Bean
    @ConditionalOnMissingClass("com.fake.NotExisting")
    public String missingClassBean() {
        return "Loaded because class is missing";
    }

    // 6. @ConditionalOnExpression
    @Bean
    @ConditionalOnExpression("${custom.value} > 5")
    public String expressionBean() {
        return "Expression Bean Loaded";
    }

    // 7. @ConditionalOnResource
    @Bean
    @ConditionalOnResource(resources = "classpath:application.yaml")
    public String resourceBean() {
        return "Resource Found Bean";
    }

    // 8. @Profile
    @Bean
    @Profile("dev")
    public String devBean() {
        return "Dev Profile Bean";
    }

    // 9. Custom @Conditional
    @Bean
    @Conditional(CustomCondition.class)
    public String customConditionalBean() {
        return "Custom Condition Bean";
    }
}
