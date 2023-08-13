package com.dipali.employee.controller;

import com.dipali.employee.entity.Project;
import com.dipali.employee.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pro")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PostMapping("/save")
    public ResponseEntity<Project> createPro(@RequestBody Project pro){
        Project pro1 = this.projectService.createPro(pro);
        return new ResponseEntity<>(pro1, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<Project>> getAll(){
        List<Project> pro = this.projectService.getPro();
        return new ResponseEntity<>(pro,HttpStatus.OK);
    }
    @DeleteMapping("/{proId}")
    public ResponseEntity<String> deleteproject(@PathVariable Long proId){

        this.projectService.deletePro(proId);
        return new ResponseEntity<>("Deleted project !!!",HttpStatus.OK);
    }

}
