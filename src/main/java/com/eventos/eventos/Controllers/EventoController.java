package com.eventos.eventos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

import com.eventos.eventos.Models.Evento;
import com.eventos.eventos.Services.EventoService;

import jakarta.validation.Valid;

@Controller
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/eventos")
    public ModelAndView index() {
        List<Evento> eventos = this.eventoService.findAll();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("eventos", eventos);
        return modelAndView;
    }

    @GetMapping("/eventos/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");

        return modelAndView;
    }

    @PostMapping("/eventos")
    public String store(@Valid Evento evento, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("message", "Verificar os campos obrigatórios");
            return "redirect:/eventos/create";
        }

        this.eventoService.save(evento);
        return "redirect:/eventos";
    }

    @GetMapping("/eventos/{id}/edit")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Evento evento = this.eventoService.findById(id);
        
        modelAndView.addObject("evento", evento);
        return modelAndView;
    }

}
