package com.cui.fighting.openfiegn;

import com.cui.fighting.api.RemoteMemberService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: open feign 实现第三方远程调用
 * @date: 2021/4/19 21:41
 * @author: wei·man cui
 */
@Slf4j
@RestController
@RequestMapping("/feign")
public class FeignOrderMemberController {

    @Resource
    private RemoteMemberService memberService;

    @GetMapping("/order")
    public String orderToMember() {
        return memberService.getUser(123789);
    }
}
