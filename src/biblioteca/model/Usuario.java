package biblioteca.model;

import biblioteca.bo.UsuarioBO;
import biblioteca.exceptions.UsuarioNaoEncontradoException;
import java.sql.SQLException;

public class Usuario extends Entidade implements Persistivel {
    private String nome;
    private String matricula;

    public Usuario(int id, String nome, String matricula) {
        super(id);
        this.nome = nome;
        this.matricula = matricula;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Implementação da interface Persistivel
    @Override
    public void salvar() {
        try {
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.adicionarUsuario(this);
        } catch (SQLException e) {
            System.err.println("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    @Override
    public void atualizar() {
        try {
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.atualizarUsuario(this);
        } catch (SQLException | UsuarioNaoEncontradoException e) {
            System.err.println("Erro ao atualizar usuário: " + e.getMessage());
        }
    }

    @Override
    public void deletar() {
        try {
            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.deletarUsuario(this.getId());
        } catch (SQLException | UsuarioNaoEncontradoException e) {
            System.err.println("Erro ao deletar usuário: " + e.getMessage());
        }
    }
}