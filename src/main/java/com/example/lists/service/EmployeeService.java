package com.example.lists.service;

import com.example.lists.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);
    List<Employee> printEmployees();
}
