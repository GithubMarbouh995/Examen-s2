package com.examen.service;

import com.examen.model.Employe;
import com.examen.repository.EmployeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeService {

    EmployeRepository employeRepository;

    public void createEmploye(Employe employe) {
        employeRepository.save(employe);

    }

    public void updateEmploye(Employe employe) {
        employeRepository.save(employe);

    }

    public void deleteEmploye(long id) {

        employeRepository.deleteById(id);

    }

    public void getEmploye(long id) {
        employeRepository.findById(id);

    }

    public List<Employe> getAllEmployes() {

        return employeRepository.findAll();
    }
}
