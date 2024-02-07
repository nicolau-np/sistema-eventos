package com.eventos.eventos.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "evento")
@Entity(name = "evento")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name = "nome_evento")
    private String nome_evento;

    @NotBlank
    @Column(name = "local")
    private String local;

    @NotBlank
    @Column(name = "tipo_evento")
    private String tipo_evento;

    @NotBlank
    @Column(name = "descricao")
    private String descricao;

    @NotBlank
    @Column(name = "preco")
    private String preco;

    @NotBlank
    @Column(name = "data")
    private String data;

    @NotBlank
    @Column(name = "hora")
    private String hora;

    public Evento(String nome_evento, String local, String tipo_evento, String descricao, String preco, String data,
            String hora) {
        this.nome_evento = nome_evento;
        this.local = local;
        this.tipo_evento = tipo_evento;
        this.descricao = descricao;
        this.preco = preco;
        this.data = data;
        this.hora = hora;
    }



}
