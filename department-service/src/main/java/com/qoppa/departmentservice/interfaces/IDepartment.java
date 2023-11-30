package com.qoppa.departmentservice.interfaces;

import com.qoppa.departmentservice.models.Department;

public interface IDepartment {
    Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);
}
