package com.basiccrud.eg.demo.controller;

import com.basiccrud.eg.demo.entity.EmployeeData;
import com.basiccrud.eg.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
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

    // show
    @GetMapping("/show")
    public List<EmployeeData> showEmp(){
        return empService.showEmp();
    }

    //update
    @PutMapping("/update/{id}")
    public EmployeeData updateEmp(@RequestBody EmployeeData empData,
                                  @PathVariable("id") long empId){
        return empService.updateEmp(empData,empId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id") long empId){
        empService.deleteEmp(empId);
        return "record deleted !";
    }
}
