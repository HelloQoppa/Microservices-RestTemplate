package com.qoppa.departmentservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qoppa.departmentservice.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
