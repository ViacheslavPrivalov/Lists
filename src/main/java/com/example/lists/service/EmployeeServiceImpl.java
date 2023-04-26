package com.example.lists.service;

import com.example.lists.Employee;
import com.example.lists.exceptions.EmployeeAlreadyAddedException;
import com.example.lists.exceptions.EmployeeNotFoundException;
import com.example.lists.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employeeList = new ArrayList<>(List.of(
            new Employee("Иван1", "Иванов1"),
            new Employee("Иван2", "Иванов2"),
            new Employee("Иван3", "Иванов3"),
            new Employee("Иван4", "Иванов4"),
            new Employee("Иван5", "Иванов5"),
            new Employee("Иван6", "Иванов6"),
            new Employee("Иван7", "Иванов7"),
            new Employee("Иван8", "Иванов8"),
            new Employee("Иван9", "Иванов9")
    ));
    private int size = 10;

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employeeList.size() != size) {
            employeeList.add(new Employee(firstName, lastName));
            return employeeList.get(employeeList.size() - 1);
        }
        for (Employee employee : employeeList) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
            }
        }
        throw new EmployeeStorageIsFullException("Хранилище переполнено");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        for (Employee employee : employeeList) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                employeeList.remove(employee);
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Такого сотрудника нет");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employeeList) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Такого сотрудника нет");
    }

    public List<Employee> printEmployees() {
        return employeeList;
    }
}
