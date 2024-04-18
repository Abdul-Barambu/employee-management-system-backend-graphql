package com.abdul.Employeemanagementsystemgraphql.repository;

import com.abdul.Employeemanagementsystemgraphql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByEmployeeNumber(String employeeNumber);
}
