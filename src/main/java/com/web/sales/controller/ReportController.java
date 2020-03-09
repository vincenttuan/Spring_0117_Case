package com.web.sales.controller;

import com.web.sales.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {
    
    @Autowired
    private ReportService service;
    
    @GetMapping("/")
    public String input(Model model) {
        model.addAttribute("list_customers", service.listCustomers());
        model.addAttribute("list_products", service.listProducts());
        return "report";
    }

}
