package com.sc.feign.api;

import com.sc.feign.error.ApiServiceError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eurekaclient", fallback = ApiServiceError.class)
public interface ApiService {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    String index();
}
