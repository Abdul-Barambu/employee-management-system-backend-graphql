package com.abdul.Employeemanagementsystemgraphql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    private Integer id;
    @Column(name = "employee_number")
    private String employeeNumber;
    private String first_name;
    private String last_name;
    private String email;
    private String department;

    public Employee(String employeeNumber, String first_name, String last_name, String email, String department) {
        this.employeeNumber = employeeNumber;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.department = department;
    }
}
