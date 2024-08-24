package com.code.springboot.crudapp.controller;


import com.code.springboot.crudapp.entity.Employee;
import com.code.springboot.crudapp.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    //add mapping for listing the employees
    @GetMapping("/list")
    public String listEmployees(Model model) {
        //getting the employees from database
        List<Employee> theEmployees = employeeService.findAll();
        model.addAttribute("employees", theEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee theEmployee = new Employee();
        model.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {
        //getting the employee from the service
        Employee theEmployee = employeeService.findById(theId);

    //setting the employee in the model to prepopulate the form
        model.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {
        //deleting the employee
        employeeService.deleteById(theId);

        //redirecting to the employee list;
        return "redirect:/employees/list";
    }
}
