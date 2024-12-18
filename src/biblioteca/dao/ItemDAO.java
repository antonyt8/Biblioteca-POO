package biblioteca.dao;

import biblioteca.ConexaoBanco;
import biblioteca.model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    // CREATE
    public void adicionarItem(Item item) throws SQLException {
        String sql = "INSERT INTO Itens (tipo, titulo, autor, edicao) VALUES (?, ?, ?, ?)";
        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, item.getTipo());
            stmt.setString(2, item.getTitulo());
            stmt.setString(3, item.getAutor());
            stmt.setInt(4, item.getEdicao());
            stmt.executeUpdate();
        }
    }

    // READ
    public List<Item> listarItens() throws SQLException {
        List<Item> itens = new ArrayList<>();
        String sql = "SELECT * FROM Itens";
        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Item item = new Item(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("edicao")
                );
                itens.add(item);
            }
        }
        return itens;
    }

    // UPDATE
    public void atualizarItem(Item item) throws SQLException {
        String sql = "UPDATE Itens SET tipo = ?, titulo = ?, autor = ?, edicao = ? WHERE id = ?";
        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, item.getTipo());
            stmt.setString(2, item.getTitulo());
            stmt.setString(3, item.getAutor());
            stmt.setInt(4, item.getEdicao());
            stmt.setInt(5, item.getId());
            stmt.executeUpdate();
        }
    }

    // DELETE
    public void deletarItem(int id) throws SQLException {
        String sql = "DELETE FROM Itens WHERE id = ?";
        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}