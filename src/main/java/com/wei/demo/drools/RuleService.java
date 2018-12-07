package com.wei.demo.drools;

/**
 * 参与业务计算的类实现RuleService接口
 */
public interface RuleService {
    /**
     * 执行规则
     * @param objects 参与执行的对象，为JavaBean数组
     */
    void execute(Object[] objects);
}
