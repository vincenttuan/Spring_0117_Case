package com.web.sales.controller;

import com.web.sales.models.DiscountCode;
import com.web.sales.services.DiscountCodeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/add")
    public String add(@ModelAttribute DiscountCode discountCode) {
        service.add(discountCode);
        return "redirect:./input";
    }

    @GetMapping("/get/{id}")
    public String get(@PathVariable("id") String id, Model model) {
        if (service.exists(id)) {
            DiscountCode discountCode = service.get(id);
            List<DiscountCode> list = service.query();
            model.addAttribute("discountCode", discountCode);
            model.addAttribute("list", list);
            model.addAttribute("action", "update");
            model.addAttribute("readonly", "true");
            return "discount_code";
        }
        return "redirect:./input";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute DiscountCode discountCode) {
        service.update(discountCode);
        return "redirect:./input";
    }
    
    @GetMapping("/delete/{id}")
    public String update(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:../input";
    }
}
