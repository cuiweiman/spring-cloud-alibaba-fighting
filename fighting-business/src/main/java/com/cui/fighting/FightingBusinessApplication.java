package com.cui.fighting;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * {@link LoadBalanced} 开启负载均衡
 *
 * @description: 启动类
 * @date: 2021/4/18 18:59
 * @author: wei·man cui
 */
@EnableFeignClients(basePackages = "com.cui.fighting")
@SpringBootApplication
public class FightingBusinessApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FightingBusinessApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args)
                .registerShutdownHook();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
