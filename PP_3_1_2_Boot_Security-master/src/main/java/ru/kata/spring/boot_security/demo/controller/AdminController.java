package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kata.spring.boot_security.demo.entity.User;

public interface AdminController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users")
    String pageUsers(ModelMap modelMap);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/create")
    String pageCreate(ModelMap modelMap);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    String create(@ModelAttribute("user") User user);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/update/{id}")
    String pageUpdate(ModelMap modelMap, @PathVariable Long id);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/update")
    String update(@ModelAttribute("user") User user);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/delete/{id}")
    String delete(@PathVariable Long id);


}
