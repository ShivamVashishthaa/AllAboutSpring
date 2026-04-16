package com.practise.filterinterceptorandaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class FilterInterceptorAndAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterInterceptorAndAopApplication.class, args);
    }

}
