package com.cesar.gestioncolegio.gestioncolegioapp.controllers;


import com.cesar.gestioncolegio.gestioncolegioapp.models.entities.User;
import com.cesar.gestioncolegio.gestioncolegioapp.services.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(originPatterns = "*")
public class UserController {

    @Autowired
    IUserService iUserService;


    @PostMapping
    public ResponseEntity<?> create (@Valid @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(iUserService.save(user));
    }

    @GetMapping
    public List<User> getAll(){
        return iUserService.findAll();

    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String,String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(),"La seccion" + err.getField() + " " + err.getDefaultMessage());

        });
        return ResponseEntity.badRequest().body(errors);
    }

}
