package com.cesar.gestioncolegio.gestioncolegioapp.services;

import com.cesar.gestioncolegio.gestioncolegioapp.models.entities.Alumno;
import com.cesar.gestioncolegio.gestioncolegioapp.repositories.IAlumnoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Override
    //Solo de lectura
    @Transactional(readOnly = true)
    public List<Alumno> findAll() {
        return (List<Alumno>) alumnoRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Alumno> findById(Long id) {
        return alumnoRepository.findById(id);

    }

    @Transactional
    @Override
    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Transactional
    @Override
    public Optional<Alumno> update(Alumno alumno, Long id) {
        Optional<Alumno> o = this.findById(id);
        if(o.isPresent()){
            Alumno alumnoDb = o.orElseThrow();
            alumnoDb.setIdAlumno(alumno.getIdAlumno());
            alumnoDb.setNombre(alumno.getNombre());
            alumnoDb.setApellido(alumno.getApellido());
            alumnoDb.setFechaNacimiento(alumno.getFechaNacimiento());
            alumnoDb.setIdCarrera(alumno.getIdCarrera());
            alumnoDb.setTelefono(alumno.getTelefono());
            return Optional.of(this.save(alumnoDb));
        }

        return Optional.empty();
    }

    @Transactional
    @Override
    public void remove(Long id) {
        alumnoRepository.deleteById(id);

    }
}
