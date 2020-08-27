package com.hcm.alipay.rest;

import com.hcm.alipay.model.AlipayUserInfoDTO;
import com.hcm.alipay.model.ScopeType;
import com.hcm.alipay.service.IAlipayPageAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chuming Huang
 * @date 2020/8/27
 */
@RestController
@RequestMapping("/v1/auth")
@Slf4j
public class AuthController {

    @Autowired
    IAlipayPageAuthService alipayPageAuthService;

    /**
     * 阿里的网页授权，获取用户信息
     *
     * @param code
     * @param scope
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public AlipayUserInfoDTO alipayUserInfo(@RequestParam String code,
                                            @RequestParam(required = false) ScopeType scope) throws Exception {
        // 没有指定授权方式，则默认为静默授权
        if (scope == null) {
            scope = ScopeType.BASE;
        }
        AlipayUserInfoDTO dto = alipayPageAuthService.getAlipayUserInfo(code, scope);
        return dto;
    }

}
