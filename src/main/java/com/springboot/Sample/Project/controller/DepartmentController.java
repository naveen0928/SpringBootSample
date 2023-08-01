package com.springboot.Sample.Project.controller;

import com.springboot.Sample.Project.entity.Department;
import com.springboot.Sample.Project.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // private final Logger logger = LoggerFactory.getLogger(name:DepartmentController.class);

    @PostMapping("/saveDepartment")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/getDepartmentsList")
    public List<Department> getDepartmentList(Department department) {
        return departmentService.getDepartmentList(department);
    }

    @GetMapping("/getDepartment/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully !!";
    }

    @PutMapping("updateDepartment/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/getDepartmentByName/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }
}
