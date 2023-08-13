package com.dipali.employee.service;

import com.dipali.employee.entity.Employee;
import com.dipali.employee.entity.Project;
import com.dipali.employee.repository.EmployeeRepository;
import com.dipali.employee.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Employee createEmp(Employee emp){

        return this.employeeRepository.save(emp);
    }

    public List<Employee> getAllemp(){
        List<Employee> employees = this.employeeRepository.findAll();
            return employees;

    }
public Employee assignproject(Long empId,Long proId){
    Set<Project>  set=null;
    Employee employee = this.employeeRepository.findById(empId).get();
    Project project = this.projectRepository.findById(proId).get();
    set= employee.getAssignproject();
    set.add(project);
    employee.setAssignproject(set);
   return this.employeeRepository.save(employee);
}

}
