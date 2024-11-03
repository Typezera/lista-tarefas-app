package com.teste.lista_tarefas_app.models;

import java.util.ArrayList;

public class Tarefa
{
    private static int contId = 0;
    private int id;
    private String titulo;
    private String descricao;
    private Status status;
    public static ArrayList<Tarefa> listaTarefa = new ArrayList<Tarefa>();

    public Tarefa(String titulo, String descricao, Status status)
    {
        this.id = contId++;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        listaTarefa.add(this);
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
