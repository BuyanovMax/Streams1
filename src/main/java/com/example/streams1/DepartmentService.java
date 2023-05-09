package com.example.streams1;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {


    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentService(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }


    public EmployeeMap findMaxSalary(int department) {

        return employeeServiceImpl.showAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(EmployeeMap::getSalary))
                .orElse(null);


    }

    public EmployeeMap findMinSalary( int department) {

        return employeeServiceImpl.showAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(EmployeeMap::getSalary))
                .orElse(null);
    }

    public List<EmployeeMap> findAllEmployeeByDepartment(int department) {

        return employeeServiceImpl.showAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .toList();
    }

    public Map<Integer, List<EmployeeMap>> findAllEmployees() {

        return employeeServiceImpl.showAllEmployees().stream()
                .collect(Collectors.groupingBy(EmployeeMap::getDepartment));

    }
}
