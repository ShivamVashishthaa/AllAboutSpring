package com.parctise.apigateway;

import io.jsonwebtoken.Claims;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();
        // skip login
        if (path.contains("/auth")) {
            return chain.filter(exchange);
        }

        String header = exchange.getRequest()
                .getHeaders().getFirst("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            throw new RuntimeException("Missing token");
        }

        String token = header.substring(7);
        Claims claims = JwtUtil.validateToken(token);

        ServerHttpRequest request = exchange.getRequest()
                .mutate()
                .header("userId", claims.getSubject())
                .build();

        return chain.filter(exchange.mutate().request(request).build());
    }
}
