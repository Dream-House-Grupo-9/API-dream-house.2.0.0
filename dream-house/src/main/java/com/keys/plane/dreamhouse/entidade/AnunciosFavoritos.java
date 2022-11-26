package com.keys.plane.dreamhouse.entidade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class AnunciosFavoritos {


    public AnunciosFavoritos() {
    }

    public AnunciosFavoritos(Integer idCliente, Integer idAnuncio) {
        this.idCliente = idCliente;
        this.idAnuncio = idAnuncio;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFavorito;

    @NotNull
    private Integer idCliente;

    @NotNull
    private Integer idAnuncio;


    public Integer getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(Integer idFavorito) {
        this.idFavorito = idFavorito;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(Integer idAnuncio) {
        this.idAnuncio = idAnuncio;
    }
}
