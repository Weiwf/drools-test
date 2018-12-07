package com.wei.demo.model;

import lombok.Data;

import java.util.List;

/**
 * @Author: weiwenfeng
 * @Date: 2018/12/7
 */
@Data
public class User {
    private String name;

    private int sex;

    private int age;

    private List<String> addrs;
}
