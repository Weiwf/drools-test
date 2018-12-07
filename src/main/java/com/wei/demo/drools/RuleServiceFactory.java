package com.wei.demo.drools;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: weiwenfeng
 * @Date: 2018/12/7
 *
 * RuleService工厂类
 */
public class RuleServiceFactory {
    /**
     * key:规则名，value:实现RuleService的具体规则
     **/
    private static ConcurrentHashMap<String, RuleService> ruleServiceMap = new ConcurrentHashMap<>();

    public static RuleService createRuleService(Rule rule) {
        String ruleName = rule.getRuleName();
        if (null != ruleServiceMap.get(ruleName)) {
            throw new RuntimeException("Rule " + ruleName + " existed!");
        } else {
            try {
                synchronized (RuleServiceFactory.class) {
                    if (null == ruleServiceMap.get(ruleName)) {
                        RuleService ruleService = new RuleServiceImpl(rule.getDrlBytes());
                        ruleServiceMap.put(ruleName, ruleService);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return ruleServiceMap.get(ruleName);
    }

    public static RuleService getRuleService(String ruleName) {
        return ruleServiceMap.get(ruleName);
    }
}
