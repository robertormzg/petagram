package com.robertormzg.petagram;

public class Pet {

    private int foto;
    private String nombre;
    private String favorito;

    public Pet(int foto, String nombre, String favorito) {
        this.foto = foto;
        this.nombre = nombre;
        this.favorito = favorito;
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

    public String getFavorito() {
        return favorito;
    }

    public void setFavorito(String favorito) {
        this.favorito = favorito;
    }
}
