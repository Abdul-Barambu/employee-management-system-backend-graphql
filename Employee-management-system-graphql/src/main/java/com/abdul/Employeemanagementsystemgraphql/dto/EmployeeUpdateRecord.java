package com.abdul.Employeemanagementsystemgraphql.dto;

public record EmployeeUpdateRecord(String employeeNumber,
                                   String first_name,
                                   String last_name,
                                   String email,
                                   String department) {
}
