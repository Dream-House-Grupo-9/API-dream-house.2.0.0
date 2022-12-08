package com.keys.plane.dreamhouse.controle;

import com.keys.plane.dreamhouse.entidade.ImagensComplementares;
import com.keys.plane.dreamhouse.estrutura.FilaObj;
import com.keys.plane.dreamhouse.repositorio.ImagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/imagens")
public class ImagensControle {

    @Autowired
    private ImagensRepository repository;

    @PostMapping("/imagens/{imagens}")
    public ResponseEntity inserirImagem(@PathVariable ImagensComplementares[] imagens){
        FilaObj<ImagensComplementares> filaImagens = null;

        if(filaImagens == null){

            return ResponseEntity.status(404).build();

        }else{
            for(int i = 0; i < imagens.length; i++){
                filaImagens.insert(imagens[i]);
            }

            while(!filaImagens.isEmpty()){
                repository.save(filaImagens.poll());
            }

            return ResponseEntity.status(201).body("imagens inseridas com sucesso!");
        }
    }
}
