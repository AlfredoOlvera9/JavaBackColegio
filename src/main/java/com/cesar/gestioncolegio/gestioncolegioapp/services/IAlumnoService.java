package com.cesar.gestioncolegio.gestioncolegioapp.services;

import com.cesar.gestioncolegio.gestioncolegioapp.models.entities.Alumno;

import java.util.List;
import java.util.Optional;

public interface IAlumnoService {
    List<Alumno> findAll();
    Optional<Alumno>findById(Long id);
    Alumno save(Alumno alumno);
    Optional<Alumno> update(Alumno alumno, Long id);
    void remove(Long id);

}
