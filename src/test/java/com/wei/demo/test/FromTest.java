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
public class FromTest extends DroolsTestApplicationTests {

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

        List<User> list = Arrays.asList(user1, user2);
        byte[] bytes = FileUtils.getFileContent("FromTest.drl");
        List<byte[]> list2 = Arrays.asList(bytes);
        DroolsUtils.execute(new Object[]{list, user2},list2);
    }
}
