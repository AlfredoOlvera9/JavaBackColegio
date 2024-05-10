package com.cesar.gestioncolegio.gestioncolegioapp.repositories;

import com.cesar.gestioncolegio.gestioncolegioapp.models.entities.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface IAlumnoRepository
        extends  CrudRepository<Alumno,Long> {

}
