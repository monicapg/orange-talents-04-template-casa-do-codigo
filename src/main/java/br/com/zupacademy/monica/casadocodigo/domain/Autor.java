package br.com.zupacademy.monica.casadocodigo.domain;

import org.hibernate.validator.constraints.Length;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Length(max = 400)
    private String descricao;
    @NotNull
    private LocalDateTime horaCadastro;

    public Autor() {
    }
    public Autor(String nome, String email, String descricao) {
        // this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setHoraCadastro(LocalDateTime horaCadastro) {
        this.horaCadastro = horaCadastro;
    }
}
