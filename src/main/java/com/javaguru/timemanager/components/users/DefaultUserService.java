package com.javaguru.timemanager.components.users;

import com.javaguru.timemanager.config.BeanConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService {

    private final UserRepository repository;
    private final BeanConverter converter;

    public DefaultUserService(UserRepository repository, BeanConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public UserEntity create(UserDto userDto) {
        UserEntity userEntity = converter.convert(userDto);
        return repository.save(userEntity);
    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    public void update(UserDto userDto) {
        if (!repository.existsById(userDto.getId())) {
            throw new IllegalArgumentException(String.format("User with id %s not found", userDto.getId()));
        }

        UserEntity userEntity = converter.convert(userDto);

        repository.save(userEntity);
    }

    public UserEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("User with id %s not found", id)));
    }

}
