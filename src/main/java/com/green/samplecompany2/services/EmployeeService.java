package com.green.samplecompany2.services;

import com.green.samplecompany2.models.Employee;
import com.green.samplecompany2.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    public Employee findAllPCs(Integer id){
        return employeeRepository.findById(id);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }
}
