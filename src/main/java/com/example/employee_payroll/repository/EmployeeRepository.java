package com.example.employee_payroll.repository;

import com.example.employee_payroll.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    List<Employee> findByDepartment(String department);
    List<Employee> findByEmployementType(String employementType);
}
