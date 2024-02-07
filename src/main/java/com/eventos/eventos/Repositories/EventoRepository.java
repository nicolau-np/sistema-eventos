package com.eventos.eventos.Repositories;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.eventos.eventos.Models.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long>{
   
    @Override
    List<Evento> findAll();

}
