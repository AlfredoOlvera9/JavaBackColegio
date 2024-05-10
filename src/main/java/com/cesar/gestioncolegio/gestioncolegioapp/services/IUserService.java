package com.cesar.gestioncolegio.gestioncolegioapp.services;

import com.cesar.gestioncolegio.gestioncolegioapp.models.entities.User;

import java.util.List;

public interface IUserService {

    User save(User user);
    List<User> findAll();


}
