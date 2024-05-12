package com.cesar.gestioncolegio.gestioncolegioapp.services;

import com.cesar.gestioncolegio.gestioncolegioapp.models.dto.UserDto;
import com.cesar.gestioncolegio.gestioncolegioapp.models.dto.mapper.DtoMapperUser;
import com.cesar.gestioncolegio.gestioncolegioapp.models.entities.User;
import com.cesar.gestioncolegio.gestioncolegioapp.repositories.IAlumnoRepository;
import com.cesar.gestioncolegio.gestioncolegioapp.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UserDto save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return DtoMapperUser.builder().setUSer(userRepository.save(user)).build();
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDto> findAll() {
        List<User> users = (List<User>) userRepository.findAll();

        return users
                .stream()
                .map(u -> DtoMapperUser.builder().setUSer(u).build())
                .collect(Collectors.toList());
    }
}
