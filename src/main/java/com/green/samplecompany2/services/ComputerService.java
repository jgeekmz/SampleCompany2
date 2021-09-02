package com.green.samplecompany2.services;

import com.green.samplecompany2.models.Computer;
import com.green.samplecompany2.repositories.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author zlatkov
 */
@Service
public class ComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    /** Save a computer to db. */
    public Computer saveComputer(Computer computer) {
       return computerRepository.save(computer);
    }

    /** Find a computer by id. */
    public Optional<Computer> findPC(Long id) {
        return computerRepository.findById(id);
    }

    /** Find all PCs in db. */
    public List<Computer> findAllPCs(){
        return computerRepository.findAll();
    }
}
