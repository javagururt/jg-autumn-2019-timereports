package com.javaguru.timemanager.components.users;

import com.javaguru.timemanager.config.BeanConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final DefaultUserService service;
    private final BeanConverter converter;

    public UserController(DefaultUserService service, BeanConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping
    public List<UserDto> findAll() {
        return service.findAll().stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        UserEntity userEntity = service.findById(id);
        return converter.convert(userEntity);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserDto userDto) {
        UserEntity userEntity = service.create(userDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userEntity.getId())
                .toUri();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .location(location)
                .build();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        service.update(userDto);
    }
}
