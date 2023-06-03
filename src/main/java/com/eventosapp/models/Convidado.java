package com.eventosapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Convidado {

    @Id
    @NotEmpty
    private String cpf;

    @NotEmpty
    private String nomeConvidado;

    @ManyToOne
    private Evento evento;

    // Getter e Setter para o atributo "rg"
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Getter e Setter para o atributo "nomeConvidado"
    public String getNomeConvidado() {
        return nomeConvidado;
    }

    public void setNomeConvidado(String nomeConvidado) {
        this.nomeConvidado = nomeConvidado;
    }

    // Getter e Setter para o atributo "evento"
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}

