package com.cesar.gestioncolegio.gestioncolegioapp.services;

import com.cesar.gestioncolegio.gestioncolegioapp.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<com.cesar.gestioncolegio.gestioncolegioapp.models.entities.User> o = repository.getUserByUsername(username);

        if(!o.isPresent()){
            throw new UsernameNotFoundException(String.format("username %s no existe", username));

        }
        com.cesar.gestioncolegio.gestioncolegioapp.models.entities.User user =o.orElseThrow();

        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                authorityList);


    }
}
