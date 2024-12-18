package biblioteca.bo;

import biblioteca.dao.ItemDAO;
import biblioteca.model.Item;
import java.sql.SQLException;
import java.util.List;

public class ItemBO {
    private ItemDAO itemDAO;

    public ItemBO() {
        this.itemDAO = new ItemDAO();
    }

    // Método para adicionar um item com validação
    public void adicionarItem(Item item) throws SQLException, IllegalArgumentException {
        if (item.getTitulo() == null || item.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("Título do item não pode ser vazio.");
        }
        itemDAO.adicionarItem(item);
    }

    // Método para listar todos os itens
    public List<Item> listarItens() throws SQLException {
        return itemDAO.listarItens();
    }

    // Método para atualizar um item
    public void atualizarItem(Item item) throws SQLException {
        itemDAO.atualizarItem(item);
    }

    // Método para deletar um item
    public void deletarItem(int id) throws SQLException {
        itemDAO.deletarItem(id);
    }
}