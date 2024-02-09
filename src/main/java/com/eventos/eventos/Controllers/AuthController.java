package com.eventos.eventos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventos.eventos.Models.User;
import com.eventos.eventos.Repositories.UserRepository;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;



@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/auth/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");

        return modelAndView;
    }

    @PostMapping("/auth/login")
    public String logar(RedirectAttributes redirectAttributes, User userParam) {
        User user = this.userRepository.Login(userParam.getEmail(), userParam.getPassword());
        if (user != null) {
            return "redirect:/eventos";
        }

        redirectAttributes.addFlashAttribute("message", "Email ou Plavra Passe Incorrectos");

        return "redirect:/auth/login";
    }

}
