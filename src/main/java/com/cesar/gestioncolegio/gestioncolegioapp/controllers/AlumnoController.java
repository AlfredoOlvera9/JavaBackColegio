package com.cesar.gestioncolegio.gestioncolegioapp.controllers;


import com.cesar.gestioncolegio.gestioncolegioapp.models.entities.Alumno;
import com.cesar.gestioncolegio.gestioncolegioapp.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
@CrossOrigin(originPatterns = "*")
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

     @GetMapping
    public List<Alumno> list(){
        return alumnoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByID(@PathVariable Long id){
        Optional<Alumno> alumnoOptional = alumnoService.findById(id);
        if(alumnoOptional.isPresent()){
            return ResponseEntity.ok(alumnoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Alumno alumno){

        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Alumno alumno, @PathVariable Long id){
        Optional<Alumno> o = alumnoService.update(alumno,id);
        if(o.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(o.orElseThrow());
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id ){
        Optional<Alumno> o = alumnoService.findById(id);
        if(o.isPresent()){
            alumnoService.remove(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }

}
