package com.green.samplecompany2.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Entity for the employee object.
 *
 * @author zlatkov
 * @since 27.08.2021
 */

@Entity(name = "employee")
public class Employee {

    @Id
    private Integer id;

    private String firstname;
    private String lastname;
    private String description;

    @ManyToMany
    @JoinTable(name = "computer2employee",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "computer_id"))
    private List<Computer> computersToEmployee;

    public Employee() {
    }

    public Employee(Integer id, String firstname, String lastname, String description,
            List<Computer> computerToEmployee) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.description = description;
        this.computersToEmployee = computerToEmployee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Computer> getComputersToEmployee() {
        return computersToEmployee;
    }

    public void setComputersToEmployee(List<Computer> computersToEmployee) {
        this.computersToEmployee = computersToEmployee;
    }

}
