package com.wei.demo.controller;

import com.wei.demo.model.Product;
import com.wei.demo.service.JewelleryShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: weiwenfeng
 * @Date: 2018/11/20
 */
@RestController
public class JewelleryShopController {

    private final JewelleryShopService jewelleryShopService;

    @Autowired
    public JewelleryShopController(JewelleryShopService jewelleryShopService) {
        this.jewelleryShopService = jewelleryShopService;
    }

    @RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
    public Product getQuestions(@RequestParam(required = true) String type) {

        Product product = new Product();
        product.setType(type);
        jewelleryShopService.getProductDiscount(product);
        return product;
    }
}
