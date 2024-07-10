package com.example.employee_payroll.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;

@Document(collection = "employees")
public class Employee {

    @Id
    private String id;
    private String name;
    private String department;
    private BigDecimal salary;

    public String getEmployementType() {
        return employementType;
    }

    public void setEmployementType(String employementType) {
        this.employementType = employementType;
    }

    private String employementType;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}

