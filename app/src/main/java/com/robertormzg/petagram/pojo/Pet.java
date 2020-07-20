package com.robertormzg.petagram.pojo;

public class Pet {
    private int id;
    private int foto;
    private String nombre;
    private int favorito;

    public Pet(int foto, String nombre, int favorito) {
        this.foto = foto;
        this.nombre = nombre;
        this.favorito = favorito;
    }

    public Pet() {

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
