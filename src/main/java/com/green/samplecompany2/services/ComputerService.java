package com.green.samplecompany2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.samplecompany2.models.Computer;
import com.green.samplecompany2.repositories.ComputerRepository;

/**
 * @author zlatkov
 */
@Service
public class ComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    /**
     * Save a computer to db.
     *
     */
    public Computer saveComputer(Computer computer) {
        return computerRepository.save(computer);
    }

    /**
     * Find a computer by id.
     *
     * @return Object of Computer.
     */
    public Optional<Computer> findPC(Integer id) {
        return computerRepository.findById(id);
    }

    /**
     * Find all PCs in db.
     *
     * @return List with all Computer in db.
     */
    public List<Computer> findAllPCs() {
        return computerRepository.findAll();
    }

    /**
     * Delete a pc in db.
     */
    public void deleteById(Integer id) {
        computerRepository.deleteById(id);
    }
}
