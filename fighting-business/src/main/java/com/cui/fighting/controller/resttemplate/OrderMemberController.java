package com.cui.fighting.controller.resttemplate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 使用 RestTemplate 调用其他服务的 API 时，服务调用的负载均衡方法：
 * 1. 对 RestTemplate 使用 @LoadBalanced 注解 实现负载均衡
 * 2. 通过使用 {@link LoadBalancerClient} 自动实现负载均衡
 *
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

    private final LoadBalancerClient loadBalancerClient;

    @GetMapping("/orderToMember")
    public String orderToMember() {
        List<ServiceInstance> instances = discoveryClient.getInstances("fighting-system");
        ServiceInstance fightingSystemInstance = instances.get(0);
        return restTemplate.getForObject(fightingSystemInstance.getUri() + "/system/member/111", String.class);
    }

    @GetMapping("/orderToMemberLoadBalanced")
    public String orderToMemberLoadBalanced() {
        return restTemplate.getForObject("http://fighting-system/system/member/123", String.class);
    }


    @GetMapping("/orderToMemberLoadBalanceClient")
    public String orderToMemberLoadBalanceClient() {
        ServiceInstance instance = loadBalancerClient.choose("fighting-system");
        log.info(instance.toString());
        // 调用失败？
        return restTemplate.getForObject(instance.getUri() + "/system/member/111", String.class);
    }

}
