package com.sc.eurekaservicetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class EurekaServiceTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceTestApplication.class, args);
    }

}
