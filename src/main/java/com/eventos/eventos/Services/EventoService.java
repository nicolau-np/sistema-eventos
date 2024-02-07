package com.eventos.eventos.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventos.eventos.Models.Evento;
import com.eventos.eventos.Repositories.EventoRepository;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> getEventoList() {

        return null;
    }

    public void save(Evento evento){
        this.eventoRepository.save(evento);
    }

}
