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
    private EmployeeService empService;

    /** Create employee in db.  */
    @PostMapping(path="/api/employees/createEmployee",consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> savePC(@RequestBody Employee employee) throws Exception {
        Employee emp = empService.saveEmployee(employee);
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
        Employee emp = empService.findAllPCs(id);
        List<Computer> computers = new ArrayList<>();

        for (int i=0; i<emp.getComputersToEmployee().size();i++){
            computers.add(emp.getComputersToEmployee().get(i));
        }

        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    /** Delete Computer mapped to an Employee. */
    @PostMapping("/api/delete/computers/{empID}/{pcID}")
    public ResponseEntity removePcFromEmployee(@PathVariable (name="empID") Integer id, @PathVariable (name="pcID") Integer pcID) {
        Employee emp = empService.findAllPCs(id);
        List<Computer> pc = emp.getComputersToEmployee();

        for (int i=0; i<emp.getComputersToEmployee().size();i++){
            Integer tempID = emp.getComputersToEmployee().get(i).getId();
            if(tempID == pcID) {
                Computer tempPC = emp.getComputersToEmployee().get(i);
                pc.remove(tempPC);
            }
        }
        emp.setComputersToEmployee(pc);
        empService.saveEmployee(emp);

        return new ResponseEntity("PC was removed", HttpStatus.OK);
    }

}
