package com.code.springboot.crudapp.dao;

import com.code.springboot.crudapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Adding a method to sort by first name
    public List<Employee> findAllByOrderByFirstNameAsc();



}
