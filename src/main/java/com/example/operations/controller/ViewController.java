package com.example.operations.controller;

import com.example.operations.repository.OperationConfig;
import com.example.operations.repository.OperationConfigRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/operations")
public class ViewController {
    private final OperationConfigRepository repo;

    public ViewController(OperationConfigRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("operation", new OperationConfig());
        return "builder";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute OperationConfig operation) {
        operation.setCreatedAt(LocalDateTime.now());
        repo.save(operation);
        return "redirect:/operations/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("operations", repo.findAll());
        return "list";
    }

}
