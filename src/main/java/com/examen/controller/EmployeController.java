package com.examen.controller;

import com.examen.service.EmployeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeController {
    EmployeService employeService;
    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @RequestMapping("/employes")
    public String getEmployesList() {
        return "employes";
    }
    @RequestMapping("/create")
    public String createNewEmploye() {
        return "create-new-employe";
    }
    public String saveEmploye() {
        return "employes";
    }
    public String updateEmploye() {
        return "employes";
    }
    public String deleteEmploye() {
        return "employes";
    }
    public String uploadImage() {
        return "employes";
    }

}
