package biblioteca.model;

public class Item {
    private int id;
    private String tipo;
    private String titulo;
    private String autor;
    private int edicao;

    // Construtores, getters e setters
    public Item(int id, String tipo, String titulo, String autor, int edicao) {
        this.id = id;
        this.tipo = tipo;
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
}