package com.eventos.eventos.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventos.eventos.Models.Evento;

import jakarta.validation.Valid;

@Controller
public class EventoController {


    @GetMapping("/eventos")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }

    @GetMapping("/eventos/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");

        return modelAndView;
    }

    @PostMapping("/eventos")
    public String store(@Valid Evento evento, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("message", "Verificar os campos obrigatórios");
           return "redirect:/eventos/create";
        }

        return "redirect:/eventos";
    }

}
