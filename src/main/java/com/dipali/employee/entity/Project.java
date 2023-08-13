package com.dipali.employee.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.repository.cdi.Eager;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proId;

    private String proName;
    @ManyToMany(mappedBy = "assignproject",cascade = CascadeType.ALL)
    private Set<Employee> emp=new HashSet<>();
}
