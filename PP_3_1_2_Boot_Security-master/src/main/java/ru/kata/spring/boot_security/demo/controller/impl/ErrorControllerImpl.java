package ru.kata.spring.boot_security.demo.controller.impl;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import ru.kata.spring.boot_security.demo.controller.ErrorController;

@ControllerAdvice
public class ErrorControllerImpl implements ErrorController {

    @Override
    public String entityNotFoundException(Throwable throwable, Model model) {
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }

    @Override
    public String RuntimeException(Throwable throwable, Model model) {
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }
}
