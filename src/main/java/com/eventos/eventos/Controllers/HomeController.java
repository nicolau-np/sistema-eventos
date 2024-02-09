package com.eventos.eventos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import com.eventos.eventos.Models.Evento;
import com.eventos.eventos.Services.EventoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/")
    public ModelAndView index(HttpSession session) {
        String response = "nada";
        if (session != null && session.getAttribute("email") != null) {
            response = "existe";
        }else{
            response = "nulo";
        }
        ModelAndView modelAndView = new ModelAndView("home");
        List<Evento> eventos = this.eventoService.findAll();

        modelAndView.addObject("eventos", eventos);
        modelAndView.addObject("sessao", response);
        return modelAndView;
    }



}
