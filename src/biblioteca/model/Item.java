package biblioteca.model;

import biblioteca.bo.ItemBO;
import java.sql.SQLException;

public class Item extends Entidade implements Persistivel {
    private String tipo;
    private String titulo;
    private String autor;
    private int edicao;

    public Item(int id, String tipo, String titulo, String autor, int edicao) {
        super(id);
        this.tipo = tipo;
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
    }

    // Getters e Setters
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

    // Implementação da interface Persistivel
    @Override
    public void salvar() {
        try {
            ItemBO itemBO = new ItemBO();
            itemBO.adicionarItem(this);
        } catch (SQLException e) {
            System.err.println("Erro ao salvar item: " + e.getMessage());
        }
    }

    @Override
    public void atualizar() {
        try {
            ItemBO itemBO = new ItemBO();
            itemBO.atualizarItem(this);
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar item: " + e.getMessage());
        }
    }

    @Override
    public void deletar() {
        try {
            ItemBO itemBO = new ItemBO();
            itemBO.deletarItem(this.getId());
        } catch (SQLException e) {
            System.err.println("Erro ao deletar item: " + e.getMessage());
        }
    }
}