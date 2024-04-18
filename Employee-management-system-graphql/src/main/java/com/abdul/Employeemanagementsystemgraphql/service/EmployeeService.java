package com.abdul.Employeemanagementsystemgraphql.service;

import com.abdul.Employeemanagementsystemgraphql.dto.EmployeeInput;
import com.abdul.Employeemanagementsystemgraphql.dto.EmployeeUpdateRecord;
import com.abdul.Employeemanagementsystemgraphql.entity.Employee;
import com.abdul.Employeemanagementsystemgraphql.exception.NotFoundException;
import com.abdul.Employeemanagementsystemgraphql.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    //    get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    //    Add Employee
    public Employee addEmployee(EmployeeInput employeeInput) {
//        create object of employee and call the input

        var emailExist = employeeRepository.findByEmail(employeeInput.email()).isPresent();
        var employeeNumberExist = employeeRepository.findByEmployeeNumber(employeeInput.employeeNumber()).isPresent();

        if (emailExist) {
            throw new NotFoundException("Email exist");
        } else if (employeeNumberExist) {
            throw new NotFoundException("Employee Already exist");
        }

        Employee employee = new Employee(
                employeeInput.employeeNumber(),
                employeeInput.first_name(),
                employeeInput.last_name(),
                employeeInput.email(),
                employeeInput.department()
        );

        return employeeRepository.save(employee);
    }

    //    update employee
    public Employee updateEmployee(Integer id, EmployeeUpdateRecord employeeUpdateRecord) {

        // Check if the email and employee number exists
        var emailExist = employeeRepository.findByEmail(employeeUpdateRecord.email()).isPresent();
        var employeeNumberExist = employeeRepository.findByEmployeeNumber(employeeUpdateRecord.employeeNumber()).isPresent();

        if (emailExist) {
            throw new NotFoundException("Email exist");
        } else if (employeeNumberExist) {
            throw new NotFoundException("Employee Already exist");
        }

        // Check if the employee exists
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee does not exist"));


//        update the one with the checked it
        // Update fields if they are not null, if you have not input it
        if (employeeUpdateRecord.employeeNumber() != null) {
            employee.setEmployeeNumber(employeeUpdateRecord.employeeNumber());
        }
        if (employeeUpdateRecord.first_name() != null) {
            employee.setFirst_name(employeeUpdateRecord.first_name());
        }
        if (employeeUpdateRecord.last_name() != null) {
            employee.setLast_name(employeeUpdateRecord.last_name());
        }
        if (employeeUpdateRecord.email() != null) {
            employee.setEmail(employeeUpdateRecord.email());
        }
        if (employeeUpdateRecord.department() != null) {
            employee.setDepartment(employeeUpdateRecord.department());
        }

        // Save and return the updated employee
        return employeeRepository.save(employee);
    }

    //    delete an employee
    public String deleteEmployee(Integer id) {
//        check if employee exist
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee does not exist"));

        employeeRepository.delete(employee);

        return "Employee deleted successfully";

    }
}
