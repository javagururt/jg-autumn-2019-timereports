package com.javaguru.timemanager.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
class UserController {

    @GetMapping
    List<UserDto> findAll() {
        throw new IllegalArgumentException("I'm sorry");
    }

    @GetMapping("/{id}")
    UserDto findById(@PathVariable Long id) {
        UserDto dto = new UserDto();
        dto.setId(id);
        dto.setName("MOCK USER");
        return dto;
    }

    @PostMapping
    ResponseEntity<Void> create(@RequestBody UserDto request) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .location(location)
                .build();
    }
}
