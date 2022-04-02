package com.aisha.aisha.controllers;

import com.aisha.aisha.entity.Department;
import com.aisha.aisha.model.service.StudentDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentDepartmentService service;

    @GetMapping("/{id}")
    public String getDepartmentId(@PathVariable Long id, Model model){
        Optional<Department> department = service.findDepartmentById(id);
        department.ifPresent(value -> {
            model.addAttribute("item", value);
            model.addAttribute("items", value.getStudents());
        });
        return "department";
    }
}
