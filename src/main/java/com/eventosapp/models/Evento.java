package com.eventosapp.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Evento implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String local;
    @NotEmpty
    private String data;
    @NotEmpty
    private String horario;
    @OneToMany
    private List<Convidado> convidados;

    // Getter e Setter para o atributo "codigo"
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    // Getter e Setter para o atributo "nome"
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para o atributo "local"
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    // Getter e Setter para o atributo "data"
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    // Getter e Setter para o atributo "horario"
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
