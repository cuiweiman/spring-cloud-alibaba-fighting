package com.cui.fighting.api;

import com.cui.fighting.api.factory.RemoteMemberServiceFallbackFactory;
import com.cui.fighting.constants.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description: 会员服务api
 * @date: 2021/4/19 21:30
 * @author: wei·man cui
 */
@FeignClient(contextId = "remoteMemberService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteMemberServiceFallbackFactory.class)
public interface RemoteMemberService {

    /**
     * 获取用户信息
     *
     * @param id id
     * @return 结果
     */
    @GetMapping("/system/member/{id}")
    String getUser(@PathVariable("id") Integer id);
}
