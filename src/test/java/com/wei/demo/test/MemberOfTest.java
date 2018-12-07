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
public class MemberOfTest extends DroolsTestApplicationTests {

    @Test
    public void test(){
        List<Integer> list = Arrays.asList(17,18,19);

        User user1 = new User();
        user1.setName("wwf");
        user1.setSex(1);
        user1.setAge(18);
        byte[] bytes = FileUtils.getFileContent("MemberOfTest.drl");
        List<byte[]> list2 = Arrays.asList(bytes);
        DroolsUtils.execute(new Object[]{list,user1},list2);
    }
}
