package com.aisha.aisha.controllers;

import com.aisha.aisha.entity.Department;
import com.aisha.aisha.entity.Student;
import com.aisha.aisha.model.service.StudentDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentDepartmentService service;
    private Long depId;

    @GetMapping("/{id}")
    public String getDepartmentId(@PathVariable Long id, Model model){
        Optional<Department> department = service.findDepartmentById(id);
        department.ifPresent(value -> {
            depId = id;
            model.addAttribute("student", new Student());
            model.addAttribute("department", value);
            model.addAttribute("items", value.getStudents());
        });
        return "department";
    }



    @PostMapping("/{id}")
    public String addStudent(@PathVariable Long id, Student student){
        Optional<Department> department = service.findDepartmentById(id);
        department.ifPresent(value -> {
            student.setId(null);
            value.addStudentToDepartment(student);
            service.saveDepartment(value);
        });
        return "redirect:/students/" + depId;
    }

    @DeleteMapping("delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
        return "redirect:/students/" + depId;
    }
}
