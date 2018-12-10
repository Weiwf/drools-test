package com.wei.demo.test;

import com.wei.demo.model.User;
import com.wei.demo.util.DroolsUtils;
import com.wei.demo.util.FileUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: weiwenfeng
 * @Date: 2018/12/10
 */
public class NoLoopTest {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("wwf");
        user1.setSex(1);
        user1.setAge(18);
        byte[] bytes = FileUtils.getFileContent("NoloopTest.drl");
        List<byte[]> bytesList = Arrays.asList(bytes);
        DroolsUtils.execute(new Object[]{user1},bytesList);
    }
}
