package com.examen.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Double budget;
    @ManyToMany(mappedBy = "projects")
    private List<Employe> employes;


    public Project() {
    }

    public Project(long id, String name, Double budget) {

        this.name = name;
        this.budget = budget;


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

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                '}';
    }
}
