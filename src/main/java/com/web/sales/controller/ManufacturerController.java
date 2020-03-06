package com.web.sales.controller;

import com.web.sales.models.Manufacturer;
import com.web.sales.services.ManufacturerService;
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
@RequestMapping("/manufacturer")
public class ManufacturerController {
    @Autowired
    private ManufacturerService service;
    
    @GetMapping("/input")
    public String input(Model model) {
        Manufacturer manufacturer = new Manufacturer();
        List<Manufacturer> list = service.query();
        model.addAttribute("manufacturer", manufacturer);
        model.addAttribute("list", list);
        model.addAttribute("action", "add");
        model.addAttribute("readonly", "false");
        return "manufacturer";
    }
    
    @PostMapping("/add")
    public String add(@ModelAttribute Manufacturer manufacturer) {
        service.add(manufacturer);
        return "redirect:./input";
    }

    @GetMapping("/get/{id}")
    public String get(@PathVariable("id") String id, Model model) {
        if (service.exists(id)) {
            Manufacturer manufacturer = service.get(id);
            List<Manufacturer> list = service.query();
            model.addAttribute("manufacturer", manufacturer);
            model.addAttribute("list", list);
            model.addAttribute("action", "update");
            model.addAttribute("readonly", "true");
            return "manufacturer";
        }
        return "redirect:./input";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute Manufacturer manufacturer) {
        service.update(manufacturer);
        return "redirect:./input";
    }
    
    @GetMapping("/delete/{id}")
    public String update(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:../input";
    }
}
