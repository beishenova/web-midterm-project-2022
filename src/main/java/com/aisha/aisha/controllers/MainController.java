package com.aisha.aisha.controllers;

import com.aisha.aisha.entity.Department;
import com.aisha.aisha.model.service.StudentDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/departments")
public class MainController {

    private final StudentDepartmentService service;

    @GetMapping
    public String getMain(Model model) {
        model.addAttribute("items", service.findAllDepartments());
        model.addAttribute("item", new Department());
        return "index";
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable("id") Long id) {
        service.deleteDepartment(id);
        return "redirect:/";
    }

    @PostMapping
    public String addDepartment(Department department) {
        service.saveDepartment(department);
        return "redirect:/";
    }

}
