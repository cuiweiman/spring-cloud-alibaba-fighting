package com.cui.fighting.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 会员服务
 * @date: 2021/4/18 15:30
 * @author: wei·man cui
 */
@RequestMapping("/member")
@RestController
public class MemberService {

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Integer userId) {
        return "用户信息".concat(userId.toString());
    }

}
