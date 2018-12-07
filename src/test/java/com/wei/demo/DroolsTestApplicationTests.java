package com.wei.demo;

import com.wei.demo.util.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DroolsTestApplicationTests {

    @Test
    public void test(){
        byte[] bytes = FileUtils.getFileContent("CommonTest.drl");
        System.out.println(bytes);
    }
}
