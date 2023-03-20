package com.basiccrud.eg.demo.service;

import com.basiccrud.eg.demo.entity.EmployeeData;
import com.basiccrud.eg.demo.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        newEmpData.setEmpDepartment(empData.getEmpDepartment());
        return empRepository.save(newEmpData);
    }

    @Override
    public void deleteEmp(long empId) {
        empRepository.deleteById(empId);
    }

    @Override
    public EmployeeData updateEmpByDept(EmployeeData empData, String empDepartment) {
        EmployeeData newEmpByDept=null;
        newEmpByDept=empRepository.findByEmpDepartment(empDepartment);
        newEmpByDept.setEmpName(empData.getEmpName());
        newEmpByDept.setEmpAddress(empData.getEmpAddress());
        newEmpByDept.setEmpDepartment(empData.getEmpDepartment());
        return empRepository.save(newEmpByDept);
    }

    @Override
    public List<EmployeeData> showEmpAsPerDepartment(String empDepartment) {
        return empRepository.findAllByEmpDepartment(empDepartment);
    }

    @Override
    public List<EmployeeData> saveListEmp(List<EmployeeData> empData) {
        return empRepository.saveAll(empData);
    }

    @Override
    public List<EmployeeData> findEmpBySort(String field) {
       return empRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    @Override
    public Page<EmployeeData> showEmpByPage(int offset, int pageSize) {
        Page<EmployeeData>  empDataByPage=null;
        empDataByPage=empRepository.findAll(PageRequest.of(offset,pageSize));

        return empDataByPage;
    }

    @Override
    public Page<EmployeeData> showEmpWithPaginationAndSorting(int offset,
                                                              int pageSize,
                                                              String anyField) {
        Page<EmployeeData> pageAndSort =empRepository
                .findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(anyField)));
        return pageAndSort;
    }
}
