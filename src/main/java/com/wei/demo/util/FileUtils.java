package com.wei.demo.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: weiwenfeng
 * @Date: 2018/12/7
 */
public class FileUtils {

    public static byte[] getFileContent(String fileName) {
        FileInputStream inputStream = null;
        byte[] fileContent = null;
        try {
            File file = ResourceUtils.getFile("classpath:rules/" + fileName);
            fileContent = new byte[(int) file.length()];
            inputStream = new FileInputStream(file);
            inputStream.read(fileContent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fileContent;
    }
}
