package com.basiccrud.eg.demo.controller;

import com.basiccrud.eg.demo.entity.EmployeeData;
import com.basiccrud.eg.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping("/greet")
    public String greet(){
        return "Welcome User !";
    }

    // save
    @PostMapping("/save")
    public EmployeeData saveEmp(@RequestBody EmployeeData empData){
        return empService.saveEmp(empData);
    }

    //  save employee list/ multiple employees
    @PostMapping("/saveListEmp")
    public List<EmployeeData> saveListEmp (@RequestBody List<EmployeeData> empData){
        return empService.saveListEmp(empData);
    }


    // show
    @GetMapping("/show")
    public List<EmployeeData> showEmp(){
        return empService.showEmp();
    }

    // show by department with @RequestParam
    @GetMapping("/showdept/")
    public List<EmployeeData> showEmpAsPerDepartment(@RequestParam("dept") String empDepartment){
        return empService.showEmpAsPerDepartment(empDepartment);
    }

    //update
    @PutMapping("/update/{id}")
    public EmployeeData updateEmp(@RequestBody EmployeeData empData,
                                  @PathVariable("id") long empId){
        return empService.updateEmp(empData,empId);
    }

    //update by path variable
    @PutMapping("/update/")
    public EmployeeData updateEmpByDept(@RequestBody EmployeeData empData,
                                        @RequestParam("dept") String empDepartment){
        return empService.updateEmpByDept(empData,empDepartment);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id") long empId){
        empService.deleteEmp(empId);
        return "record deleted !";
    }

    // Find data by sorting (asc/desc/field i.e--> name/department/id .. etc)
   @GetMapping("/showempsort/{id}")
    public List<EmployeeData> findEmpBySort(@PathVariable("id") long empId){
        return empService.findEmpBySort(empId);
    }

    //pagination
    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<EmployeeData> showEmpByPage(@PathVariable("offset") int offset,
                                            @PathVariable("pageSize") int pageSize){
        return empService.showEmpByPage(offset,pageSize);
    }
}
