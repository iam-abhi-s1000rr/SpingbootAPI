package com.basiccrud.eg.demo.repository;

import com.basiccrud.eg.demo.entity.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface EmpRepository extends JpaRepository<EmployeeData,Long>, Serializable {

    List<EmployeeData> findAllByEmpDepartment(String empDepartment);


    EmployeeData findByEmpDepartment(String empDepartment);
}
