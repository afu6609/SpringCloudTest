package com.sc.gatewayservice.Filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class ApiFilter implements GlobalFilter, Ordered {

    private static final String TOKEN_PARAM = "token";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        // 获取请求参数token
        String token = request.getQueryParams().getFirst(TOKEN_PARAM);
        System.out.println("token:" + token);
        // 校验token
        if (token == null || !"12345".equals(token)) {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.writeWith(Mono.just(response.bufferFactory().wrap("token is invalid.".getBytes())));
        }

        // 校验通过，继续执行下一个过滤器
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0; // 设置执行优先级
    }
}
