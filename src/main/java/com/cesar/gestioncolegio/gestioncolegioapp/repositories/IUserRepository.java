package com.cesar.gestioncolegio.gestioncolegioapp.repositories;

import com.cesar.gestioncolegio.gestioncolegioapp.models.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository
        extends CrudRepository<User,Long> {
}
