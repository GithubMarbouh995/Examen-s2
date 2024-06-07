package com.examen.service;

import com.examen.model.Project;
import com.examen.repository.PojectRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ProjectService {
    PojectRepository projectRepository;
        public void createProject(Project project) {
            projectRepository.save(project);
        }
        public void updateProject(Project project) {
            projectRepository.save(project);
        }

        public void deleteProject(long id) {
            projectRepository.deleteById(id);
        }
        public void getProject(long id) {
            projectRepository.findById(id);
        }
        public List<Project> getAllProjects() {
            return projectRepository.findAll();
        }


}
