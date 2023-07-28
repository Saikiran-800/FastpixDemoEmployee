package com.fastpix.EmployeeDemoApplication.services;

import com.fastpix.EmployeeDemoApplication.dto.EmployeeDTO;
import com.fastpix.EmployeeDemoApplication.entities.Employee;
import com.fastpix.EmployeeDemoApplication.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public List<EmployeeDTO> getAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setName(employee.getName());
            employeeDTO.setAge(employee.getAge());
            employeeDTO.setSalary(employee.getSalary());
            employeeDTO.setGender(employee.getGender());
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }
    public EmployeeDTO getEmployeeById(UUID id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setName(employee.getName());
            employeeDTO.setAge(employee.getAge());
            employeeDTO.setSalary(employee.getSalary());
            employeeDTO.setGender(employee.getGender());
            return employeeDTO;
        }
        return null;
    }
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO){
        if(employeeDTO!=null){
            Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDTO.getId());
            if(optionalEmployee.isPresent()){
                Employee employee = optionalEmployee.get();
                employee.setName(employeeDTO.getName());
                employee.setAge(employeeDTO.getAge());
                employee.setSalary(employeeDTO.getSalary());
                employee.setGender(employeeDTO.getGender());
                employeeRepository.save(employee);
                return employeeDTO;
            }
        }
        return null;
    }
    public EmployeeDTO registerEmployee(EmployeeDTO employeeDTO){
        if(employeeDTO!=null){
            Employee employee = new Employee();
            employee.setId(employeeDTO.getId());
            employee.setName(employeeDTO.getName());
            employee.setAge(employeeDTO.getAge());
            employee.setSalary(employeeDTO.getSalary());
            employee.setGender(employeeDTO.getGender());
            Employee savedEmployee = employeeRepository.save(employee);
            employeeDTO.setId(savedEmployee.getId());
            return employeeDTO;
        }
        return null;
    }
    public Map<String, Boolean> deleteEmployeeById(UUID id){
        employeeRepository.deleteById(id);
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Map<String,Boolean> map = new HashMap<>();
        map.put("EmployeeDeleted", false);
        if(optionalEmployee.isEmpty()){
            map.put("EmployeeDeleted", true);
            return map;
        }
        return map;
    }
}
