package ru.kata.spring.boot_security.demo.controller.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.controller.AdminController;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@AllArgsConstructor
@RequestMapping("/admin")
@Controller
public class AdminControllerImpl implements AdminController {

    private final UserService userService;

    @Override
    public String pageUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.findAll());
        return "user_list";
    }

    @Override
    public String pageCreate(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "user_create";
    }

    @Override
    public String create(User user) {
        userService.save(user);
        return "redirect:/user_list";
    }

    @Override
    public String pageUpdate(ModelMap modelMap, Long id) {
        modelMap.addAttribute("user", userService.findOne(id));
        return "user_update";
    }

    @Override
    public String update(User user) {
        userService.save(user);
        return "redirect:/user_list";
    }

    @Override
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/user_list";
    }
}
