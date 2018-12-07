package com.wei.demo.test;

import com.wei.demo.DroolsTestApplicationTests;
import com.wei.demo.drools.RuleService;
import com.wei.demo.drools.RuleServiceImpl;
import com.wei.demo.model.User;
import com.wei.demo.util.DroolsUtils;
import com.wei.demo.util.FileUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: weiwenfeng
 * @Date: 2018/12/7
 */
public class CommonTest extends DroolsTestApplicationTests {
    @Test
    public void test() {
        User user1 = new User();
        user1.setName("wwf");
        user1.setSex(1);
        user1.setAge(18);

        User user2 = new User();
        user2.setName("www");
        user2.setSex(0);
        user2.setAge(25);

        User user3 = new User();
        user3.setName("ddd");
        user3.setSex(0);
        user3.setAge(20);

        byte[] bytes = FileUtils.getFileContent("CommonTest.drl");
        List<byte[]> list = Arrays.asList(bytes);
        RuleService ruleService = new RuleServiceImpl(list);

        ruleService.execute(new Object[]{user1,user2,user3});
    }
}
