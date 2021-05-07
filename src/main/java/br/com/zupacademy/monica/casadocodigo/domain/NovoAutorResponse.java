package br.com.zupacademy.monica.casadocodigo.domain;

public class NovoAutorResponse {
    private String nome, descricao;

    public NovoAutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();

    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
