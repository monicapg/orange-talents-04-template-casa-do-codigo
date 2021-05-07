package br.com.zupacademy.monica.casadocodigo.controller;

import br.com.zupacademy.monica.casadocodigo.domain.categoria.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
   EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<Categoria> cadastrar(@RequestBody @Validated String nome) {

        Categoria categoria = new Categoria(nome);
        entityManager.persist(categoria);

        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }
}
