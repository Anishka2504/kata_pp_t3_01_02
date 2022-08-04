package ru.kata.spring.boot_security.demo.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

public interface LoginController {

    @GetMapping({"/login", "/"})
    String login(ModelMap modelMap);

    @GetMapping("/login_error")
    String loginError(ModelMap model);
}
