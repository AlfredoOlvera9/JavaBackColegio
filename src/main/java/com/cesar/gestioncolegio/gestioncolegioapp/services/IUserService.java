package com.cesar.gestioncolegio.gestioncolegioapp.services;

import com.cesar.gestioncolegio.gestioncolegioapp.models.dto.UserDto;
import com.cesar.gestioncolegio.gestioncolegioapp.models.entities.User;

import java.util.List;

public interface IUserService {

    UserDto save(User user);
    List<UserDto> findAll();


}
