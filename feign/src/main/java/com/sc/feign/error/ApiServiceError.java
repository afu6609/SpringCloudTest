package com.sc.feign.error;

import com.sc.feign.api.ApiService;
import org.springframework.stereotype.Component;

@Component
public class ApiServiceError implements ApiService {
    @Override
    public String index() {
        return "服务故障";
    }
}
