package com.springboot.Sample.Project.service;

import com.springboot.Sample.Project.entity.Department;
import com.springboot.Sample.Project.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DocumentRepository documentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return documentRepository.save(department);
    }

    @Override
    public List<Department> getDepartmentList(Department department) {
        return documentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return documentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        documentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDb = documentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDb.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentCode()) &&
        !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDb.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
        !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }
        return documentRepository.save(depDb);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return documentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
