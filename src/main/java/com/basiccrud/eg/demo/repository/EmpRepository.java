package com.basiccrud.eg.demo.repository;

import com.basiccrud.eg.demo.entity.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<EmployeeData,Long> {
}
