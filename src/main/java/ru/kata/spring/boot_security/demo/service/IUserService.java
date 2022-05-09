package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface IUserService {

    List<User> index();

    User show(long id);

    void save(User user);

    void update(long id, User user);

    void delete(long id);



}