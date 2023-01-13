package com.siit.hospital_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {

    @GetMapping
    public String showHomePage(Model model) {
       model.addAttribute("message", "Welcome!!!");
       return "index";
    }
}
