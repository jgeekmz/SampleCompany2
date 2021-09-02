package com.green.samplecompany2.repositories;

import com.green.samplecompany2.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    /** Find all assigned PCs for one employee */
    Employee findById(Integer id);

}
