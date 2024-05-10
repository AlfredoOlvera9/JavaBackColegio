package com.cesar.gestioncolegio.gestioncolegioapp.services;

import com.cesar.gestioncolegio.gestioncolegioapp.models.entities.User;
import com.cesar.gestioncolegio.gestioncolegioapp.repositories.IAlumnoRepository;
import com.cesar.gestioncolegio.gestioncolegioapp.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Transactional
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
}
