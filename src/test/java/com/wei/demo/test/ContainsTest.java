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
public class ContainsTest extends DroolsTestApplicationTests {
    @Test
    public void test(){
        User user = new User();
        user.setName("www");
        user.setSex(1);
        user.setAge(18);
        user.setAddrs(Arrays.asList("湖南","广东"));
        byte[] bytes = FileUtils.getFileContent("ContainsTest.drl");
        List<byte[]> list = Arrays.asList(bytes);
        DroolsUtils.execute(new Object[]{user},list);
    }
}
