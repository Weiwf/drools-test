package com.wei.demo.test;

import com.wei.demo.DroolsTestApplicationTests;
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
public class MatchesTest extends DroolsTestApplicationTests {
    @Test
    public void test(){
        User user = new User();
        user.setName("张三");
        byte[] bytes = FileUtils.getFileContent("MatchesTest.drl");
        List<byte[]> list = Arrays.asList(bytes);
        DroolsUtils.execute(new Object[]{user},list);
    }
}
