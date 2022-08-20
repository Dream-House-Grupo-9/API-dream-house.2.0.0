package com.keys.plane.dreamhouse.controle;

import com.keys.plane.dreamhouse.entidade.Anuncio;
import com.keys.plane.dreamhouse.entidade.AnunciosFavoritos;
import com.keys.plane.dreamhouse.repositorio.AnuncioRepository;
import com.keys.plane.dreamhouse.repositorio.AnunciosFavoritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/anuncios-favoritos")
public class AnunciosFavoritosControle {

    @Autowired
    private AnunciosFavoritosRepository repository;

    @Autowired
    private AnuncioRepository anuncioRepository;

    @PostMapping("/{idCliente}/{idAnuncio}")
    public ResponseEntity adicionarFavorito(
            @PathVariable Integer idCliente,
            @PathVariable Integer idAnuncio

    ){
        if(repository.countByIdClienteAndIdAnuncio(idCliente,idAnuncio) > 1){

            repository.save(new AnunciosFavoritos(idCliente,idAnuncio));

            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<List<Anuncio>> consultarFavoritos(@PathVariable Integer idCliente){
       List<Integer> idAnuncios = repository.consultarFavoritos(idCliente);

       List<Anuncio> anunciosFavoritos =  anuncioRepository.findByIdIn(Collections.singleton(idAnuncios));

       if(!anunciosFavoritos.isEmpty()){
           return ResponseEntity.status(200).body(anunciosFavoritos);
       }
       return ResponseEntity.status(204).build();
    }
}
