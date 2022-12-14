package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.User;

public interface UserService extends CommonService<User>{

    User findByLogin(String login);
}
