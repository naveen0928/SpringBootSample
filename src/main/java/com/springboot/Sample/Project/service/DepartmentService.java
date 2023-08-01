package com.springboot.Sample.Project.service;

import com.springboot.Sample.Project.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    List<Department> getDepartmentList(Department department);

    Department getDepartmentById(Long departmentId);

    public void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department getDepartmentByName(String departmentName);
}
