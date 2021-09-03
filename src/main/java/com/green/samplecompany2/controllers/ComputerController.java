package com.green.samplecompany2.controllers;

import com.green.samplecompany2.exception.ComputerExceptionNotFound;
import com.green.samplecompany2.models.Computer;
import com.green.samplecompany2.services.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zlatkov
 * @since 27.08.2021
 */

@RestController
public class ComputerController {

    @Autowired
    private ComputerService pcService;

    /** Find PC by id.
     * @return*/
    @GetMapping("/api/computers/findPC/{id}")
    public Computer findPC(@PathVariable Integer id) {
        return pcService.findPC(id).orElseThrow(() -> new ComputerExceptionNotFound(id));
    }

    /** Find all PCs in db. */
    @GetMapping("/api//computers/findAll")
    public List<Computer> findAllPCs(){
        return pcService.findAllPCs();
    }

    /** Create PC in db. */
    @PostMapping(path="/api//computers/createPC",consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Computer> saveComputers(@RequestBody Computer computer) throws Exception {
        Computer pc = pcService.saveComputer(computer);
        if (pc == null) {
            throw new Exception();
        } else {
            return new ResponseEntity<>(pc, HttpStatus.CREATED);
        }
    }

    /** Delete PC from db. */
    @DeleteMapping("/api/computers/delete/{id}")
    void deleteCompuer(@PathVariable Integer id) {
        pcService.deleteById(id);
    }

    /** Update a computer in db. */
    @PutMapping("/api/computers/update/{id}")
    Computer replaceComputer(@RequestBody Computer newPc, @PathVariable Integer id){
        return pcService.findPC(id)
                .map(pc -> {
                    pc.setComputerName(newPc.getComputerName());
                    pc.setDescription(newPc.getDescription());
                    pc.setEmployeeAbbreviation(newPc.getEmployeeAbbreviation());
                    pc.setIpAddress(newPc.getIpAddress());
                    pc.setMacAddress(newPc.getMacAddress());
                    return pcService.saveComputer(pc);
                }).orElseGet(() -> {
                    newPc.setId(id);
                    return pcService.saveComputer(newPc);
                });
    }

    /** Remove PC from Employee object. */
    @PutMapping("/api/computers/remove/{id}")
    Computer removeComputerFromEmployee(@RequestBody Computer newPc, @PathVariable Integer id){
        return pcService.findPC(id)
                .map(pc -> {
                    pc.setEmployeeAbbreviation(newPc.getEmployeeAbbreviation());
                    return pcService.saveComputer(pc);
                }).orElseGet(() -> {
                    newPc.setId(id);
                    return pcService.saveComputer(newPc);
                });
    }


    /** Helper Method */
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
