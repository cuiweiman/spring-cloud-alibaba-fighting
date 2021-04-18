package com.cui.fighting.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @description: 会员控制器
 * @date: 2021/4/18 19:01
 * @author: wei·man cui
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/orderMember")
public class OrderMemberController {

    private final DiscoveryClient discoveryClient;

    private final RestTemplate restTemplate;

    @GetMapping("/orderToMember")
    public String orderToMember() {
        List<ServiceInstance> instances = discoveryClient.getInstances("fighting-system");
        ServiceInstance fightingSystemInstance = instances.get(0);
        return restTemplate.getForObject(fightingSystemInstance.getUri() + "/system/member/111", String.class);
    }

}
