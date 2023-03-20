package com.basiccrud.eg.demo.service;

import com.basiccrud.eg.demo.entity.EmployeeData;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmpService {
    EmployeeData saveEmp(EmployeeData empData);

    List<EmployeeData> showEmp();

    EmployeeData updateEmp(EmployeeData empData, long empId);

    void deleteEmp(long empId);


    EmployeeData updateEmpByDept(EmployeeData empData, String empDepartment);

    List<EmployeeData> showEmpAsPerDepartment(String empDepartment);

    List<EmployeeData> saveListEmp(List<EmployeeData> empData);

    List<EmployeeData> findEmpBySort(String field);

    Page<EmployeeData> showEmpByPage(int offset, int pageSize);

    Page<EmployeeData> showEmpWithPaginationAndSorting(int offset, int pageSize, String anyField);
}
