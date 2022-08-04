package ru.kata.spring.boot_security.demo.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.controller.LoginController;

@Controller
@RequestMapping
public class LoginControllerImpl implements LoginController {

    @Override
    public String login(ModelMap modelMap) {
        return "login";
    }

    @Override
    public String loginError(ModelMap modelMap) {
        modelMap.addAttribute("loginError", true);
        return "login";
    }
}
