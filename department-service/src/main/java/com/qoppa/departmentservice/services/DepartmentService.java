package com.qoppa.departmentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qoppa.departmentservice.interfaces.IDepartment;
import com.qoppa.departmentservice.models.Department;
import com.qoppa.departmentservice.repositories.DepartmentRepository;

@Service
public class DepartmentService implements IDepartment {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
       return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

}
