package com.example.streams1;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements com.example.streams1.EmployeeService {
    private final Map<String, com.example.streams1.EmployeeMap> employeeMap;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public com.example.streams1.EmployeeMap createEmployee(String firstName, String lastName, int salary, int department) {
        EmployeeMap employee = new EmployeeMap(firstName,lastName,salary,department);
        if (employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
        } else {
            this.employeeMap.put(employee.getFullName(), employee);
        }
        return employee;
    }

    @Override
    public com.example.streams1.EmployeeMap removeEmployee(String firstname, String lastName, int salary, int department) {
       EmployeeMap employee = new EmployeeMap(firstname, lastName,salary,department);
        if (employeeMap.containsKey(employee.getFullName())) {
            return employeeMap.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public com.example.streams1.EmployeeMap findEmployee(String firstname, String lastName, int salary, int department) {
        EmployeeMap employee = new EmployeeMap(firstname, lastName,salary,department);
        if (employeeMap.containsKey(employee.getFullName())) {
            return employeeMap.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Collection<com.example.streams1.EmployeeMap> showAllEmployees() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }


    public Map<String, com.example.streams1.EmployeeMap> collection() {
        return employeeMap;
    }


}
