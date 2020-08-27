package com.hcm.alipay.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Chuming Huang
 * @date 2020/8/27
 */
@Getter
@Setter
@ToString
public class AlipayUserInfoDTO implements Serializable {

    private String alipayUserId;
    private String userId;

}
