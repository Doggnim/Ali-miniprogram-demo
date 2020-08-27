package com.hcm.alipay.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.hcm.alipay.model.AlipayUserInfoDTO;
import com.hcm.alipay.model.ScopeType;
import com.hcm.alipay.service.IAlipayPageAuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Chuming Huang
 * @date 2020/8/27
 */
@Service
public class AlipayPageAuthServiceImpl implements IAlipayPageAuthService {

    @Value("${mini.alipay.gateway}")
    String serverUrl;

    @Value("${mini.alipay.appId}")
    String appId;

    @Value("${mini.alipay.privateKey}")
    String privateKey;

    @Value("${mini.alipay.format}")
    String format;

    @Value("${mini.alipay.charset}")
    String charset;

    @Value("${mini.alipay.alipayPublicKey}")
    String alipayPublicKey;

    @Value("${mini.alipay.signType}")
    String signType;

    // test code : 2f3b392c8a804a958b0c7a283cc3YA68

    /**
     * 支付宝网页授权
     * 根据code值拉取用户信息
     *
     * @param code
     * @param scopeType BASE:静默授权  USER_INFO：显式授权
     * @return
     * @throws Exception
     */
    @Override
    public AlipayUserInfoDTO getAlipayUserInfo(String code, ScopeType scopeType) throws Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId,
                privateKey, format, charset, alipayPublicKey, signType);

        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        // 授权码
        request.setCode(code);
        request.setGrantType("authorization_code");

        AlipaySystemOauthTokenResponse response = alipayClient.execute(request);

        AlipayUserInfoDTO alipayUserInfoDTO = new AlipayUserInfoDTO();
        if (response.isSuccess()) {
            alipayUserInfoDTO.setUserId(response.getUserId());
            alipayUserInfoDTO.setAlipayUserId(response.getAlipayUserId());
            System.out.println("userId = " + response.getUserId());
            System.out.println("AlipayUserId = " + response.getAlipayUserId());
        }

        return alipayUserInfoDTO;
    }
}
