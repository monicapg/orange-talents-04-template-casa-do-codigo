package br.com.zupacademy.monica.casadocodigo.controller;

import br.com.zupacademy.monica.casadocodigo.domain.Autor;
import br.com.zupacademy.monica.casadocodigo.domain.NovoAutorRequest;
import br.com.zupacademy.monica.casadocodigo.domain.NovoAutorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    EntityManager entityManager;

    @GetMapping("/listar-autores")
    public String listarAutores() {
        return "Controller tá ok";
    }

    @PostMapping
    @Transactional
    public ResponseEntity<NovoAutorResponse> cadastrarAutor(@RequestBody @Validated NovoAutorRequest novoAutorRequest) {

        //Autor autor = new Autor(novoAutorRequest.getNome(),novoAutorRequest.getEmail(), novoAutorRequest.getDescricao());
        Autor autor = novoAutorRequest.toEntity();

        autor.setHoraCadastro(LocalDateTime.now());
        entityManager.persist(autor);

        NovoAutorResponse resp = new NovoAutorResponse(autor);
        return ResponseEntity.status(HttpStatus.OK).body(resp);

    }

}
