package br.com.thiagosousa.cardview.model;

public class Postagem {

    private String titulo;
    private String hora;
    private String descricao;
    private int imagemResource;

    public Postagem() {
    }

    public Postagem(String titulo, String hora, String descricao, int imagemResource) {
        this.titulo = titulo;
        this.hora = hora;
        this.descricao = descricao;
        this.imagemResource = imagemResource;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getImagemResource() {
        return imagemResource;
    }

    public void setImagemResource(int imagemResource) {
        this.imagemResource = imagemResource;
    }
}
