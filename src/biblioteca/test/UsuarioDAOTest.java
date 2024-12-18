package biblioteca.test;

import biblioteca.dao.UsuarioDAO;
import biblioteca.model.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class UsuarioDAOTest {
    private UsuarioDAO usuarioDAO;

    @Before
    public void setUp() {
        usuarioDAO = new UsuarioDAO();
    }

    @Test
    public void testAdicionarUsuario() throws SQLException {
        Usuario usuario = new Usuario(0, "João Silva", "12345");
        usuarioDAO.adicionarUsuario(usuario);
        assertEquals(1, usuarioDAO.listarUsuarios().size());
    }

    @Test
    public void testAtualizarUsuario() throws SQLException {
        Usuario usuario = new Usuario(0, "Maria Souza", "67890");
        usuarioDAO.adicionarUsuario(usuario);
        int id = usuarioDAO.listarUsuarios().get(0).getId();

        Usuario usuarioAtualizado = new Usuario(id, "Maria Silva", "67890");
        usuarioDAO.atualizarUsuario(usuarioAtualizado);
        assertEquals("Maria Silva", usuarioDAO.listarUsuarios().get(0).getNome());
    }

    @Test
    public void testDeletarUsuario() throws SQLException {
        Usuario usuario = new Usuario(0, "Carlos Oliveira", "54321");
        usuarioDAO.adicionarUsuario(usuario);
        int id = usuarioDAO.listarUsuarios().get(0).getId();

        usuarioDAO.deletarUsuario(id);
        assertEquals(0, usuarioDAO.listarUsuarios().size());
    }
}