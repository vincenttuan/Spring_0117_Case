package com.web.sales.controller;

import com.web.sales.models.DiscountCode;
import com.web.sales.services.DiscountCodeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/discount_code")
public class DiscountCodeController {
    
    @Autowired
    private DiscountCodeService service;
    
    @GetMapping("/input")
    public String input(Model model) {
        DiscountCode discountCode = new DiscountCode();
        List<DiscountCode> list = service.query();
        model.addAttribute("discountCode", discountCode);
        model.addAttribute("list", list);
        model.addAttribute("action", "add");
        model.addAttribute("readonly", "false");
        return "discount_code";
    }
    
}
