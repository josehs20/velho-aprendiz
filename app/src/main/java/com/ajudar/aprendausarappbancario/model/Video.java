package com.ajudar.aprendausarappbancario.model;

public class Video {

    String link;
    String titulo;

    public Video(){
    }

    public Video(String titulo,String link) {
        this.titulo = titulo;
        this.link = link;
    }

    public String getTipo() {
        return titulo;
    }

    public void setTipo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
