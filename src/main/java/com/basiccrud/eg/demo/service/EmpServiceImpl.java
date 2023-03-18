package com.basiccrud.eg.demo.service;

import com.basiccrud.eg.demo.entity.EmployeeData;
import com.basiccrud.eg.demo.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService{
    @Autowired
    private EmpRepository empRepository;
    @Override
    public EmployeeData saveEmp(EmployeeData empData) {
        return empRepository.save(empData);
    }

    @Override
    public List<EmployeeData> showEmp() {
        return empRepository.findAll();
    }

    @Override
    public EmployeeData updateEmp(EmployeeData empData, long empId) {
        EmployeeData newEmpData=null;
        newEmpData=empRepository.getReferenceById(empId);
        newEmpData.setEmpName(empData.getEmpName());
        newEmpData.setEmpAddress(empData.getEmpAddress());
        return empRepository.save(newEmpData);
    }

    @Override
    public void deleteEmp(long empId) {
        empRepository.deleteById(empId);
    }
}
