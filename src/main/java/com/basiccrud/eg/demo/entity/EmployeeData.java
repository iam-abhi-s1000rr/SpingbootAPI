package com.basiccrud.eg.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long empId;
    private String empName;
    private String empAddress;
    private String empDepartment;
}
