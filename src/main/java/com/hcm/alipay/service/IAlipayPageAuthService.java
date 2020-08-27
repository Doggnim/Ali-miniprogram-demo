package com.hcm.alipay.service;

import com.hcm.alipay.model.AlipayUserInfoDTO;
import com.hcm.alipay.model.ScopeType;

/**
 * @author Chuming Huang
 * @date 2020/8/27
 */
public interface IAlipayPageAuthService {

    /**
     * 支付宝网页授权
     * 根据code值拉取用户信息
     *
     * @param code
     * @param scopeType BASE:静默授权  USER_INFO：显式授权
     * @return
     * @throws Exception
     */
    AlipayUserInfoDTO getAlipayUserInfo(String code, ScopeType scopeType) throws Exception;
}
