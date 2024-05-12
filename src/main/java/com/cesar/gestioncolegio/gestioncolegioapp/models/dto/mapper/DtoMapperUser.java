package com.cesar.gestioncolegio.gestioncolegioapp.models.dto.mapper;

import com.cesar.gestioncolegio.gestioncolegioapp.models.dto.UserDto;
import com.cesar.gestioncolegio.gestioncolegioapp.models.entities.User;

public class DtoMapperUser {

    private static DtoMapperUser mapper;
    private User user;
    private DtoMapperUser() {
    }

    public static DtoMapperUser builder() {
        mapper = new DtoMapperUser();
        return mapper;
    }

    public DtoMapperUser setUSer(User user){
        this.user = user;
        return mapper;
    }

    public UserDto build(){
        if(user == null){
            throw new RuntimeException("Debe er clase entity");
        }
        return new UserDto(this.user.getUserID(), user.getUsername(), user.getEmail());
    }
}
