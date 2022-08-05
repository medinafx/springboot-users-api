package com.nisum.users.controller;

import com.nisum.users.model.User;
import com.nisum.users.repository.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    UserController(final UserRepository eventRepository) {
        this.userRepository = eventRepository;
    }

    @GetMapping("/users/{id:[0-9]{1,10}}")
    User one(@PathVariable Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @GetMapping("/users")
    List<User> all() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    User post(@RequestBody @Valid User user) {
        setPhoneUser(user);
        return this.userRepository.save(user);
    }

    @PutMapping("/users/{id:[0-9]{1,10}}")
    @ResponseStatus(HttpStatus.OK)
    User replace(@RequestBody @Valid User newUser, @PathVariable Integer id) {
        newUser.setId(id);
        setPhoneUser(newUser);
        return this.userRepository.save(newUser);
    }

    private static void setPhoneUser(User user) {
        if (user!= null && user.getPhones() != null && !user.getPhones().isEmpty()) {
            user.getPhones().forEach(phone -> phone.setUser(user));
        }
    }

    @PatchMapping({"/users", "/users/{id}"})
    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED, reason = "The API does not allow parcial modifications")
    void patch() {
    }

    @DeleteMapping("/users/{id:[0-9]{1,10}}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable Integer id) {
        try {
            this.userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(id);
        }
    }
}
