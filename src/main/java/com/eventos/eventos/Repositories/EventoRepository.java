package com.eventos.eventos.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.eventos.eventos.Models.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long>{
    
}
