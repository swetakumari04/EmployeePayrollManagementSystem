package com.example.employee_payroll.service;

import com.example.employee_payroll.model.Employee;
import com.example.employee_payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> getEmployeesByEmployementType(String employementType) {
        return employeeRepository.findByEmployementType(employementType);
    }


}
