package com.javaguru.timemanager.config;

import com.javaguru.timemanager.components.users.UserDto;
import com.javaguru.timemanager.components.users.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class BeanConverter {

    public UserDto convert(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setName(userEntity.getName());
        userDto.setVersion(userEntity.getVersion());
        return userDto;
    }

    public UserEntity convert(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setId(userDto.getId());
        userEntity.setVersion(userDto.getVersion());
        return userEntity;
    }
}
