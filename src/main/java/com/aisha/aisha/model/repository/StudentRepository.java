package com.aisha.aisha.model.repository;

import com.aisha.aisha.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
