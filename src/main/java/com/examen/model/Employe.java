package com.examen.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Employe")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    @ElementCollection
    @CollectionTable(
            name = "Employe_Skill",
            joinColumns = @JoinColumn(name = "employe_id")
    )
    @Column(name = "skill")
    private List<String> skills;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employe_project",
            joinColumns = @JoinColumn(name = "employe_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projects;

    public Employe() {
        projects = new ArrayList<>();
        skills = new ArrayList<>();
    }

    public Employe(long id, String name, String email, List<String> skill) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.skills = skill;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     public List<String> getSkills() {
          return skills;
     }
     public void setSkills(List<String> skill) {
          this.skills = (ArrayList<String>) skill;
     }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
