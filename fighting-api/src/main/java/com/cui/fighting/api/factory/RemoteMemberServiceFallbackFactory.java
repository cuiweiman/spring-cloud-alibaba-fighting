package com.cui.fighting.api.factory;

import com.cui.fighting.api.RemoteMemberService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description: 会员服务API 远程服务 回调配置
 * @date: 2021/4/19 21:35
 * @author: wei·man cui
 */
@Component
public class RemoteMemberServiceFallbackFactory implements FallbackFactory<RemoteMemberService> {

    private static final Logger log = LoggerFactory.getLogger(RemoteMemberServiceFallbackFactory.class);

    @Override
    public RemoteMemberService create(Throwable throwable) {
        log.error("用户信息调用失败:{}", throwable.getMessage());
        return new RemoteMemberService() {
            @Override
            public String getUser(Integer id) {
                return "用户信息调用失败";
            }
        };
    }
}
