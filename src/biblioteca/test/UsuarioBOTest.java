package biblioteca.test;

import biblioteca.bo.UsuarioBO;
import biblioteca.exceptions.UsuarioNaoEncontradoException;
import biblioteca.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioBOTest {
    private UsuarioBO usuarioBO;

    @BeforeEach
    public void setUp() {
        usuarioBO = new UsuarioBO();
    }

    @Test
    public void testAdicionarUsuario() throws SQLException {
        Usuario usuario = new Usuario(0, "João Silva", "12345");
        usuarioBO.adicionarUsuario(usuario);

        // Verifica se o usuário foi adicionado
        assertEquals(1, usuarioBO.listarUsuarios().size());
    }

    @Test
    public void testAtualizarUsuario() throws SQLException, UsuarioNaoEncontradoException {
        // Adiciona um usuário
        Usuario usuario = new Usuario(0, "Maria Souza", "67890");
        usuarioBO.adicionarUsuario(usuario);

        // Obtém o ID do usuário adicionado
        int id = usuarioBO.listarUsuarios().get(0).getId();

        // Atualiza o usuário
        Usuario usuarioAtualizado = new Usuario(id, "Maria Silva", "67890");
        usuarioBO.atualizarUsuario(usuarioAtualizado);

        // Verifica se o nome foi atualizado
        assertEquals("Maria Silva", usuarioBO.listarUsuarios().get(0).getNome());
    }

    @Test
    public void testDeletarUsuario() throws SQLException, UsuarioNaoEncontradoException {
        // Adiciona um usuário
        Usuario usuario = new Usuario(0, "Carlos Oliveira", "54321");
        usuarioBO.adicionarUsuario(usuario);

        // Obtém o ID do usuário adicionado
        int id = usuarioBO.listarUsuarios().get(0).getId();

        // Deleta o usuário
        usuarioBO.deletarUsuario(id);

        // Verifica se o usuário foi removido
        assertEquals(0, usuarioBO.listarUsuarios().size());
    }

    @Test
    public void testAtualizarUsuarioInvalido() {
        // Tenta atualizar um usuário com ID inválido
        Usuario usuario = new Usuario(-1, "Teste", "11111");
        assertThrows(UsuarioNaoEncontradoException.class, () -> {
            usuarioBO.atualizarUsuario(usuario);
        });
    }

    @Test
    public void testDeletarUsuarioInvalido() {
        // Tenta deletar um usuário com ID inválido
        assertThrows(UsuarioNaoEncontradoException.class, () -> {
            usuarioBO.deletarUsuario(-1);
        });
    }
}