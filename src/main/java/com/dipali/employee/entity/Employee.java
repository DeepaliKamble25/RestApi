package com.dipali.employee.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String empName;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "emp-proj",
            joinColumns = @JoinColumn(name = "emp_Id"),
            inverseJoinColumns= @JoinColumn(name = "project_Id"))
    private Set<Project> assignproject = new HashSet<>();
}
