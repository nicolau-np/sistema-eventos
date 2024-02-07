package com.eventos.eventos.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventos.eventos.Models.User;

import jakarta.validation.Valid;

@Controller
public class AuthController {

    @GetMapping("/auth/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");

        return modelAndView;
    }

    @PostMapping("/auth/login")
    public String logar(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("message", "Verificar os campos obrigatórios");
            return "redirect:/auth/login";
        }

        return "hello";
    }

}
