package com.aisha.aisha.controllers;

import com.aisha.aisha.model.service.StudentDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

    private final StudentDepartmentService service;

    @GetMapping("/list")
    public String getMain() {
        return "index";
    }

}
