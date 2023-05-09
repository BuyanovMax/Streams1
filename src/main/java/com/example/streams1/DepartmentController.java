package com.example.streams1;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public EmployeeMap findMaxSalary(@RequestParam("departmentId") int department) {
        return this.departmentService.findMaxSalary(department);
    }
    @GetMapping(path = "/min-salary")
    public EmployeeMap findMinSalary(@RequestParam("departmentId") int department) {
        return this.departmentService.findMinSalary(department);
    }
    @GetMapping(value = "/all",params = "departmentId")
    public List<EmployeeMap> findAllEmployeeByDepartment(@RequestParam("departmentId") int department) {
        return this.departmentService.findAllEmployeeByDepartment(department);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<EmployeeMap>> findAllEmployees() {
        return this.departmentService.findAllEmployees();
    }
}
