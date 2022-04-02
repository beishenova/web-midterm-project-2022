package com.aisha.aisha.model.repository;

import com.aisha.aisha.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
