package biblioteca.test;

import biblioteca.dao.ItemDAO;
import biblioteca.model.Item;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ItemDAOTest {
    private ItemDAO itemDAO;

    @Before
    public void setUp() {
        itemDAO = new ItemDAO();
    }

    @Test
    public void testAdicionarItem() throws SQLException {
        Item item = new Item(0, "Livro", "Java", "Autor", 1);
        itemDAO.adicionarItem(item);
        assertEquals(1, itemDAO.listarItens().size());
    }

    @Test
    public void testAtualizarItem() throws SQLException {
        Item item = new Item(0, "Livro", "Java", "Autor", 1);
        itemDAO.adicionarItem(item);
        int id = itemDAO.listarItens().get(0).getId();

        Item itemAtualizado = new Item(id, "Livro", "Python", "Outro Autor", 2);
        itemDAO.atualizarItem(itemAtualizado);
        assertEquals("Python", itemDAO.listarItens().get(0).getTitulo());
    }

    @Test
    public void testDeletarItem() throws SQLException {
        Item item = new Item(0, "Livro", "Java", "Autor", 1);
        itemDAO.adicionarItem(item);
        int id = itemDAO.listarItens().get(0).getId();

        itemDAO.deletarItem(id);
        assertEquals(0, itemDAO.listarItens().size());
    }
}