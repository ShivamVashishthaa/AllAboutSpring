package com.parctise.apigateway.controller;

import com.parctise.apigateway.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public Map<String, String> login() {
        String userId = "ShivamVashishtha"; // dummy
        String token = JwtUtil.generateToken(userId);
        return Map.of("accessToken", token);
    }
}
