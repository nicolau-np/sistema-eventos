package com.eventos.eventos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import com.eventos.eventos.Models.Evento;
import com.eventos.eventos.Services.EventoService;

@Controller
public class HomeController {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Evento> eventos = this.eventoService.findAll();

        modelAndView.addObject("eventos", eventos);
        return modelAndView;
    }

}
