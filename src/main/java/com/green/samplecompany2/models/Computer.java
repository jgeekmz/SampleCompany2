package com.green.samplecompany2.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity for the Computer Object.
 *
 * @author zlatkov
 * @since 27.08.2021
 */

@Entity(name = "computer")
public class Computer {

    @Id
    private Integer id;

    @NotEmpty
    @NotNull
    private String computerName;
    @NotEmpty
    @NotNull
    private String macAddress;
    @NotEmpty
    @NotNull
    private String ipAddress;

    //@ManyToMany(mappedBy = "computersToEmployee")
    @NotEmpty
    @NotNull
    @Size(min=3,max=3)
    private String employeeAbbreviation;
    private String description;

    public Computer() { }

    public Computer(Integer id, String macAddress, String computerName, String ipAddress, String employeeAbbreviation, String description) {
        this.id = id;
        this.macAddress = macAddress;
        this.computerName = computerName;
        this.ipAddress = ipAddress;
        this.employeeAbbreviation = employeeAbbreviation;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMacAddress() {
        return macAddress;
    }
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
    public String getComputerName() {
        return computerName;
    }
    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public String getEmployeeAbbreviation() {
        return employeeAbbreviation;
    }
    public void setEmployeeAbbreviation(String employeeAbbreviation) { this.employeeAbbreviation = employeeAbbreviation; }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override public String toString() {
        return "Computer{" +
                "id=" + id + ", macAddress='" + macAddress + '\'' + ", computerName='" + computerName + '\'' + ", employeeAbbreviation='" + employeeAbbreviation + '\'' +
                ", description='" + description + '\'' + '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Computer computer = (Computer) o;

        if (!macAddress.equals(computer.macAddress))
            return false;
        if (!computerName.equals(computer.computerName))
            return false;
        if (!ipAddress.equals(computer.ipAddress))
            return false;
        if (!employeeAbbreviation.equals(computer.employeeAbbreviation))
            return false;
        return description.equals(computer.description);
    }

    @Override public int hashCode() {
        int result = macAddress.hashCode();
        result = 31 * result + computerName.hashCode();
        result = 31 * result + ipAddress.hashCode();
        result = 31 * result + employeeAbbreviation.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
