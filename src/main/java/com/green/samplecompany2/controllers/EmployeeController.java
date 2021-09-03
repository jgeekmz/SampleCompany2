package com.green.samplecompany2.controllers;

import com.green.samplecompany2.models.Computer;
import com.green.samplecompany2.models.Employee;
import com.green.samplecompany2.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zlatkov
 * @since 27.08.2021
 */

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /** Create employee in db.  */
    @PostMapping(path="/api/employees/createEmployee",consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> savePC(@RequestBody Employee employee) throws Exception {
        Employee emp = employeeService.saveEmployee(employee);
        if (emp == null) {
            throw new Exception();
        } else {
            ResponseEntity<Employee> tResponseEntity = new ResponseEntity<>(emp, HttpStatus.CREATED);
            return tResponseEntity;
        }
    }

    /** Find all computers linked to one Employee Object. */
    @GetMapping("/api/findAllPCsForEmployee/{id}")
    public ResponseEntity<List<Computer>> findAllPCsForEmployee(@PathVariable Integer id) {
        Employee emp = employeeService.findAllPCs(id);
        List<Computer> computers = new ArrayList<>();

        for (int i=0; i<emp.getComputersToEmployee().size();i++){
            computers.add(emp.getComputersToEmployee().get(i));
        }

        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    /** Delete Computer mapped to an Employee. */
    @PostMapping("/api/delete/computers/{empID}/{pcID}")
    public ResponseEntity removePcFromEmployee(@PathVariable (name="empID") Integer id, @PathVariable (name="pcID") Integer pcID) {
        Employee employee = employeeService.findAllPCs(id);
        List<Computer> computer = employee.getComputersToEmployee();

        for (int i=0; i<employee.getComputersToEmployee().size();i++){
            Integer searchedEmployeeID = employee.getComputersToEmployee().get(i).getId();
            if(searchedEmployeeID == pcID) {
                Computer computerToBeRemoved = employee.getComputersToEmployee().get(i);
                computer.remove(computerToBeRemoved);
            }
        }
        employee.setComputersToEmployee(computer);
        employeeService.saveEmployee(employee);

        return new ResponseEntity("PC was removed", HttpStatus.OK);
    }

}
