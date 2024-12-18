package biblioteca.bo;

import biblioteca.dao.UsuarioDAO;
import biblioteca.exceptions.UsuarioNaoEncontradoException;
import biblioteca.model.Usuario;
import java.sql.SQLException;
import java.util.List;

public class UsuarioBO {
    private UsuarioDAO usuarioDAO;

    public UsuarioBO() {
        this.usuarioDAO = new UsuarioDAO();
    }

    // Método para adicionar um usuário
    public void adicionarUsuario(Usuario usuario) throws SQLException {
        usuarioDAO.adicionarUsuario(usuario);
    }

    // Método para listar todos os usuários
    public List<Usuario> listarUsuarios() throws SQLException {
        return usuarioDAO.listarUsuarios();
    }

    // Método para atualizar um usuário
    public void atualizarUsuario(Usuario usuario) throws SQLException, UsuarioNaoEncontradoException {
        if (usuario.getId() <= 0) {
            throw new UsuarioNaoEncontradoException("ID do usuário inválido para atualização.");
        }
        usuarioDAO.atualizarUsuario(usuario);
    }

    // Método para deletar um usuário
    public void deletarUsuario(int id) throws SQLException, UsuarioNaoEncontradoException {
        if (id <= 0) {
            throw new UsuarioNaoEncontradoException("ID do usuário inválido para exclusão.");
        }
        usuarioDAO.deletarUsuario(id);
    }
}