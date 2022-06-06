package com.keys.plane.dreamhouse.controle;
import com.keys.plane.dreamhouse.entidade.DetalhesAnuncio;
import com.keys.plane.dreamhouse.repositorio.AnuncioRepository;
import com.keys.plane.dreamhouse.repositorio.DetalhesAnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/detalhes-anuncio")
public class DetalhesAnuncioControle {


    @Autowired
    private DetalhesAnuncioRepository repository;

    @Autowired
    private AnuncioRepository repositoryAnuncio;


    @PostMapping
    public ResponseEntity cadastrarDetalhesAnuncio(@Valid @RequestBody DetalhesAnuncio detalhe) {


        if (detalhe != null) {

            repository.save(detalhe);


            return ResponseEntity.status(201).build();
        }

        return ResponseEntity.status(400).build();
    }


    @GetMapping
    public ResponseEntity<List<DetalhesAnuncio>> listarDetalhes() {
        List<DetalhesAnuncio> detalhes = repository.findAll();
        if (detalhes.isEmpty()) {
            return ResponseEntity.status(204).body(detalhes);
        }

        return ResponseEntity.status(200).body(detalhes);
    }


    @DeleteMapping
    public ResponseEntity deletarTodos() {
        repository.deleteAll();

        return ResponseEntity.status(200).build();
    }


    @PutMapping("/{codigo}")
    public ResponseEntity atualizaDetalhesAnuncio(@Valid @PathVariable Integer codigo,
                                                  @RequestBody DetalhesAnuncio detalhesAnuncioAtuaslizado) {
        if (repository.existsById(codigo)) {

            detalhesAnuncioAtuaslizado.setIdDetalhesAnuncio(codigo);
            repository.save(detalhesAnuncioAtuaslizado);

            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity deletarDetalheAnuncio(@Valid @PathVariable Integer codigo) {

        if (repository.existsById(codigo)) {
            repository.deleteById(codigo);

            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/exportar-detalhes-anuncio")
    public ResponseEntity detalhes() {
        List<DetalhesAnuncio> lista = repository.findAll();
        String relatorio = "";
        for (DetalhesAnuncio detalhesAnuncio : lista) {
            relatorio += ""+detalhesAnuncio.getIdDetalhesAnuncio()+", "+detalhesAnuncio.isAtivoDiaria()+"," +
                    ""+detalhesAnuncio.isAtivoSemanal()+", "+detalhesAnuncio.isAtivoMensal()+"," +
                    ""+detalhesAnuncio.getValorDiaria()+", "+detalhesAnuncio.getValorSemanal()+"," +
                    ""+detalhesAnuncio.getValorMes()+", "+detalhesAnuncio.getQtdDormitorios()+"," +
                    ""+detalhesAnuncio.getQtdToaletes()+", "+detalhesAnuncio.isGaragem()+", " +
                    ""+detalhesAnuncio.isAreaDeTrabalho()+" ,"+detalhesAnuncio.isMobiliada()+"\r\n";
        }
        return ResponseEntity
                .status(200)
                .header("content-type", "text/csv")
                .header("content-disposition", "filename=\"relatorio-do-detalhes-de-anuncios.csv\"")
                .body(relatorio);
    }

}
