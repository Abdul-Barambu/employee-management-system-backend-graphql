package com.abdul.Employeemanagementsystemgraphql.controller;

import com.abdul.Employeemanagementsystemgraphql.dto.EmployeeInput;
import com.abdul.Employeemanagementsystemgraphql.dto.EmployeeUpdateRecord;
import com.abdul.Employeemanagementsystemgraphql.entity.Employee;
import com.abdul.Employeemanagementsystemgraphql.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @QueryMapping
    List<Employee> employees() {
        return employeeService.getAllEmployees();
    }

    @MutationMapping
    Employee addEmployee(@Argument EmployeeInput employeeInput) {
        return employeeService.addEmployee(employeeInput);
    }

    @MutationMapping
    Employee updateEmployee(@Argument Integer id, @Argument EmployeeUpdateRecord employeeUpdateRecord) {
        return employeeService.updateEmployee(id, employeeUpdateRecord);
    }

    @MutationMapping
    String deleteEmployee(@Argument Integer id){
        return employeeService.deleteEmployee(id);
    }

}
