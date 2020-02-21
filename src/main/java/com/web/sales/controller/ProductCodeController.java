package com.web.sales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product_code")
public class ProductCodeController {
    @GetMapping("/input")
    public String input() {
        return "product_code";
    }
}
