package com.aoeai.aircraft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AircraftServiceApplication {

    // 《Spring微服务实战》中描述了3种调用机制，详见4.5 使用服务发现来查找服务 P93，以下来自4.6 小结
    // 1. 使用 Spring Cloud 服务 DiscoveryClient
    // 2. 使用 Spring Cloud 和支持 Ribbon 的 RestTemplate （本示例采用的该方法）
    // 3. 使用 Spring Cloud 和 Netflix 的 Feign 客户端

    // 使用带有Ribbon功能的Spring RestTemplate调用服务
    // @LoadBalanced注解告诉Spring Cloud创建一个支持Ribbon的RestTemplate
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(AircraftServiceApplication.class, args);
    }
}
