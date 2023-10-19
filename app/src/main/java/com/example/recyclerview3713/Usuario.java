package com.example.recyclerview3713;

class Usuario {
    String nome;
    int idade;
    int imagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public Usuario(String nome, int idade, int imagem) {
        this.nome = nome;
        this.idade = idade;
        this.imagem = imagem;
    }
}
