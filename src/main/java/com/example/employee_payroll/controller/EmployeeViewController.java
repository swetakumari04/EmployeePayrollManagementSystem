package com.example.employee_payroll.controller;

import com.example.employee_payroll.model.Employee;
import com.example.employee_payroll.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/employee")
public class EmployeeViewController {

    @Autowired
    private EmployeeService employeeService;

//    @GetMapping("/")
//    public String index() {
//        return "home/index";
//    }

    @GetMapping("/redoc")
    public String redoc(){
        return "redoc/redoc";
    }

    @GetMapping("/")
    public String employee(Model model){
        model.addAttribute("employeelist", employeeService.getAllEmployees());
        return "employee/list";
    }
//    @GetMapping("/")
//    public String employeeById(Model model, @RequestParam("id") String id){
//        model.addAttribute("employeeId",id);
//        model.addAttribute("employeeList", employeeService.getEmployeeById(id));
//        return "employee/list";
//    }

    @GetMapping("/add")
    public String add(@ModelAttribute("employee") final Employee employee){
        return "employee/add";
    }
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") @Valid Employee employee) {
        employeeService.addEmployee(employee);
        return "employee/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, final Model model){
        Optional<Employee> deletedEmployee = employeeService.getEmployeeById(id);
        Employee employee = deletedEmployee.get();
        model.addAttribute("employee", employee);
        return "employee/edit";
    }
    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable String id, @ModelAttribute("employee") @Valid Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return "employee/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id,Model model) {
        Optional<Employee> deletedEmployee = employeeService.getEmployeeById(id);
        Employee employee = null;
        if (deletedEmployee.isPresent()) {
            employee = deletedEmployee.get();
            String deletedEmployeeName = employee.getName();
            String deletedEmployeeId = employee.getId();
            String deletedEmployeeDepartment = employee.getDepartment();
            model.addAttribute("deletedEmployeeName",deletedEmployeeName);
            model.addAttribute("deletedEmployeeId",deletedEmployeeId);
            model.addAttribute("deletedEmployeeDepartment",deletedEmployeeDepartment);

            System.out.println("Name: " + deletedEmployeeName);
            System.out.println("ID: " + deletedEmployeeId);
            System.out.println("Department: " + deletedEmployeeDepartment);
        } else {
            employee=null;
        }
//        model.addAttribute("employee",employee);
        employeeService.deleteEmployee(id);
        return "employee/list";
    }

//    @GetMapping("/{department}")
//    public String getEmployeesByDepartment(Model model, @RequestParam("department") String department){
//        model.addAttribute("department",department);
//        model.addAttribute("employeeList",employeeService.getEmployeesByDepartment(department));
//        return "employee/list";
//    }

//    @GetMapping("/{employementType}")
//    public String getEmployeesByEmployementType(Model model, @RequestParam("employementType") String employementType){
//        model.addAttribute("employementType",employementType);
//        model.addAttribute("employeeList",employeeService.getEmployeesByEmployementType(employementType));
//        return "employee/list";
//    }


}
