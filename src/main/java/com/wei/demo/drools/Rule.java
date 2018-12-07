package com.wei.demo.drools;

import lombok.Data;

import java.util.List;

/**
 * @Author: weiwenfeng
 * @Date: 2018/12/7
 */
@Data
public class Rule {
    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 规则版本
     */
    private String ruleVesion;

    /**
     * drl规则文件字节码
     */
    private List<byte[]> drlBytes;
}
