package biblioteca.dao;

import biblioteca.ConexaoBanco;
import biblioteca.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // CREATE
    public void adicionarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO Usuarios (nome, matricula) VALUES (?, ?)";
        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getMatricula());
            stmt.executeUpdate();
        }
    }

    // READ (Listar todos os usuários)
    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";
        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("matricula")
                );
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    // UPDATE
    public void atualizarUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuarios SET nome = ?, matricula = ? WHERE id = ?";
        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getMatricula());
            stmt.setInt(3, usuario.getId());
            stmt.executeUpdate();
        }
    }

    // DELETE
    public void deletarUsuario(int id) throws SQLException {
        String sql = "DELETE FROM Usuarios WHERE id = ?";
        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}