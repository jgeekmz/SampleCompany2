package com.green.samplecompany2.controllers;

import com.green.samplecompany2.models.Computer;
import com.green.samplecompany2.services.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author zlatkov
 */
@RestController
public class ComputerController {

    @Autowired
    private ComputerService pcService;

    /** Create PC. */
    @PostMapping(path="/createPC",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Computer> saveComputers(@RequestBody Computer computer) throws Exception {
        Computer pc = pcService.saveComputer(computer);
        if (pc == null) {
            throw new Exception();
        } else {
            return new ResponseEntity<>(pc, HttpStatus.CREATED);
        }
    }

    /** Find PC by id. */
    @GetMapping("/findPC/{id}")
    public ResponseEntity<Computer> findPC(@PathVariable Long id) {
        Optional<Computer> pc = pcService.findPC(id);
        return new ResponseEntity<>(pc.get(), HttpStatus.OK);
    }

    /** Find all PCs. */
    @GetMapping("/findAll")
    public List<Computer> findAllPCs(){
        return pcService.findAllPCs();
    }

    /** Delete PC. */
    //TODO


    /** Remove PC from Employee. */


    //
    // Helper Method
    private Computer createPC(){
        Computer pc = new Computer();
        pc.setComputerName("PC Test");
        pc.setId(1);
        pc.setDescription("Test");
        pc.setIpAddress("192.168.0.1");
        pc.setMacAddress("AK:45:44:AB:GT:J8");
        pc.setEmployeeAbbreviation("mmu");
        return pc;
    }
}
