package com.keys.plane.dreamhouse.repositorio;


import com.keys.plane.dreamhouse.entidade.AnunciosFavoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnunciosFavoritosRepository extends JpaRepository<AnunciosFavoritos,Integer> {

    @Query("select a.idAnuncio from AnunciosFavoritos a where a.idCliente = ?1")
    List<Integer> consultarFavoritos(Integer idCliente);


    Integer countByIdClienteAndIdAnuncio(Integer idCliente, Integer idAnuncio);

    Integer countByidAnuncio(Integer idAnuncio);
}
