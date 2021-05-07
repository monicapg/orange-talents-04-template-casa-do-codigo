package br.com.zupacademy.monica.casadocodigo.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoAutorRequest {
    @NotBlank
    String nome;
    @NotBlank
    @Length(max = 400)
    String descricao;
    @NotBlank
    @Email
    String email;

    NovoAutorRequest(){}

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmail() {
        return email;
    }

    public Autor toEntity() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
