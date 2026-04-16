package com.practise.filterinterceptorandaop.controller;

import com.practise.filterinterceptorandaop.service.MyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MyController {
    private final MyService myService;

    @GetMapping("/demp")
    public String demo() {
        log.info("Inside Controller before service method");
        myService.method();
        log.info("Inside Controller after service method");
        return "demo";
    }
}
