package com.cesar.gestioncolegio.gestioncolegioapp.repositories;

import com.cesar.gestioncolegio.gestioncolegioapp.models.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUserRepository
        extends CrudRepository<User,Long> {

    Optional<User> findByUsername(String username);

    //Es a el modelo no a la tabla
    @Query("select u from User u where u.username=?1")
    Optional<User> getUserByUsername(String username);

}
