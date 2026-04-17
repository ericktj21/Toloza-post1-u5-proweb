package com.ejemplo.model;

public class Tarea {
    private int id;
    private String titulo;
    private boolean completada;

    public Tarea() {
    }

    public Tarea(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.completada = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}
