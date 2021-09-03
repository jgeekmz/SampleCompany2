package com.green.samplecompany2.exception;

/**
 * @author zlatkov
 */
public class ComputerExceptionNotFound extends RuntimeException {

    public ComputerExceptionNotFound(Integer id) {
        super("Could not find computer with this id: " + id);
    }
}
