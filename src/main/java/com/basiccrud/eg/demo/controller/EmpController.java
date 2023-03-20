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
   @GetMapping("/showempsort/{anyfield}")
    public List<EmployeeData> findEmpBySort(@PathVariable("anyfield") String field){
        return empService.findEmpBySort(field);
    }

    //pagination
    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<EmployeeData> showEmpByPage(@PathVariable("offset") int offset,
                                            @PathVariable("pageSize") int pageSize){
        return empService.showEmpByPage(offset,pageSize);
    }
    //pagination woth sorting
    @GetMapping("/pageinationwithsort/{offset}/{pageSize}/{Field}")
    public Page<EmployeeData> showEmpWithPaginationAndSorting(@PathVariable("offset") int offset,
                                                        @PathVariable("pageSize") int pageSize,
                                                        @PathVariable("Field")String anyField){
        return empService.showEmpWithPaginationAndSorting(offset,pageSize,anyField);
    }
}
