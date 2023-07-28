package com.fastpix.EmployeeDemoApplication.controllers;

import com.fastpix.EmployeeDemoApplication.dto.EmployeeDTO;
import com.fastpix.EmployeeDemoApplication.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/getEmployee/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") UUID id){
        return employeeService.getEmployeeById(id);
    }
    @PutMapping("/updateEmployee")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(employeeDTO);
    }
    @PostMapping("/registerEmployee")
    public EmployeeDTO registerEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.registerEmployee(employeeDTO);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public Map<String, Boolean> deleteEmployeeById(@PathVariable("id") UUID id){
        return employeeService.deleteEmployeeById(id);
    }
}
