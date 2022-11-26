package com.keys.plane.dreamhouse.repositorio;

import com.keys.plane.dreamhouse.entidade.Anuncio;
import com.keys.plane.dreamhouse.resposta.CardAnuncioViews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.List;

public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {

    long countBy();

    List<Anuncio> findByIdIn(Collection<List<Integer>> id);

    List<Anuncio> findByCidade(String cidade);

    List<Anuncio> findByDetalheAtivoDiariaTrue();

    List<Anuncio> findByDetalheAtivoSemanalTrue();

    List<Anuncio> findByDetalheAtivoMensalTrue();

    List<Anuncio> findByDetalheValorDiariaBetween(Double valor1,Double valor2);

    List<Anuncio> findByDetalheValorSemanalBetween(Double valor1,Double valor2);

    List<Anuncio> findByDetalheValorMesBetween(Double valor1,Double valor2);

    List<Anuncio> findByClienteId(Integer id);

    @Query("select new com.keys.plane.dreamhouse.resposta.CardAnuncioViews(a.bairro, a.cidade, a.detalhe.valorMes) from Anuncio a where a.cliente.id = ?1")
    List<CardAnuncioViews> consultaAnuncioCard(Integer id);


    @Query("select a.foto from Anuncio a where a.id = ?1")
    byte[] getFoto(Integer id);

    @Query("update Anuncio a set a.foto =?2 where a.id = ?1")
    @Transactional
    @Modifying
    int atualizarFoto(Integer id, byte[] novaFoto);

}
