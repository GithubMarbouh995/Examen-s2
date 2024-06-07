package com.examen.controller;

import com.examen.service.EmployeService;
import com.examen.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ControllerJson {
    private EmployeService employeService;
    private ProjectService projectService;








}
