package com.cui.fighting;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @description: 启动类
 * @date: 2021/4/18 15:15
 * @author: wei·man cui
 */
@SpringBootApplication
public class FightingSystemApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FightingSystemApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args)
                .registerShutdownHook();

    }
}
