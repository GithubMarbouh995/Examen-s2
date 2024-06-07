package com.examen.controller;

import com.examen.service.ProjectService;
import org.springframework.stereotype.Controller;

@Controller
public class ProjectController {
    ProjectService projectService;
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    public String getProjectsList() {
        return "projects";
    }
    public String createNewProject() {
        return "create-new-project";
    }
    public String saveProject() {
        return "projects";
    }
    public String updateProject() {
        return "projects";
    }
    public String deleteProject() {
        return "projects";
    }
    public String uploadImage() {
        return "projects";
    }
}
