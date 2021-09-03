package com.green.samplecompany2.controllers;

import com.green.samplecompany2.models.Computer;
import com.green.samplecompany2.models.Employee;
import com.green.samplecompany2.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlatkov
 * @since 27.08.2021
 */
@Controller
@Slf4j
public class DashboardController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value="/admin-notify",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<String> dashboard() {
        List<String> listNames = new ArrayList<>();
        List<Employee> pcs = employeeService.findAllEmployee();

        //log.info("Inside dashboard controller!");

        for(Employee p : pcs) {
            if(p.getComputersToEmployee().size() >= 3 ) {
                listNames.add(p.getFirstname() + " " + p.getLastname());
            }
        }
        return listNames;
    }


}
