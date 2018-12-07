package com.wei.demo.drools;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: weiwenfeng
 * @Date: 2018/12/7
 */
public class RuleServiceFactory2 {
    /**
     * key:规则名，value:实现RuleService的具体规则
     **/
    private static ConcurrentHashMap<String, RuleService> ruleServiceMap = new ConcurrentHashMap<>();
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void setRuleService(Rule rule) {
        String ruleName = rule.getRuleName();
        if (null != ruleServiceMap.get(ruleName)) {
            throw new RuntimeException("Rule " + ruleName + " existed!");
        } else {
            try {
                lock.writeLock().lock();
                if (null == ruleServiceMap.get(ruleName)) {
                    RuleService ruleService = new RuleServiceImpl(rule.getDrlBytes());
                    ruleServiceMap.put(ruleName, ruleService);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    public static RuleService getRuleService(String ruleName) {
        RuleService ruleService;
        ruleService = ruleServiceMap.get(ruleName);
        try {
            lock.readLock().lock();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.readLock().unlock();
        }
        return ruleService;
    }
}
