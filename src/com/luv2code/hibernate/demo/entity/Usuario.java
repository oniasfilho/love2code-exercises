package com.luv2code.hibernate.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cpf;
    private String nome;
    private String email;
    @Column(name = "data_de_criacao")
    private LocalDate dataDeCriacao;
    @Column(name = "ultima_atualizacao")
    private LocalDate ultimaAtualizacao;
    private String status;
    @ManyToMany(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    @JoinTable(
            name = "dispositivo_usuario",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "dispositivo_id")
    )
    private List<Dispositivo> dispositivos;

    public Usuario() {
    }

    public void addDispositivo(Dispositivo dispositivo){
        if(this.dispositivos == null){
            dispositivos = new ArrayList<>();
        }
        dispositivos.add(dispositivo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDate dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public LocalDate getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDate ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }
}


