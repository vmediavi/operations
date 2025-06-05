package com.example.operations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewController {
    @GetMapping("/")
    public String showBuilder(Model model) {
        model.addAttribute("availableOperations", List.of("sum", "average", "div", "prod", "subs", "sqr", "exp"));
        return "builder";
    }

}
