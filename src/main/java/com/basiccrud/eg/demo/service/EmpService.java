package com.basiccrud.eg.demo.service;

import com.basiccrud.eg.demo.entity.EmployeeData;

import java.util.List;

public interface EmpService {
    EmployeeData saveEmp(EmployeeData empData);

    List<EmployeeData> showEmp();

    EmployeeData updateEmp(EmployeeData empData, long empId);

    void deleteEmp(long empId);
}
