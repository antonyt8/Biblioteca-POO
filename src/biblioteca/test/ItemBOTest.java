package biblioteca.test;

import biblioteca.bo.ItemBO;
import biblioteca.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ItemBOTest {
    private ItemBO itemBO;

    @BeforeEach
    public void setUp() {
        itemBO = new ItemBO();
    }

    @Test
    public void testAdicionarItem() throws SQLException {
        Item item = new Item(0, "Livro", "Java", "Autor", 1);
        itemBO.adicionarItem(item);
        assertEquals(1, itemBO.listarItens().size());
    }

    @Test
    public void testAtualizarItem() throws SQLException {
        Item item = new Item(0, "Livro", "Java", "Autor", 1);
        itemBO.adicionarItem(item);
        int id = itemBO.listarItens().get(0).getId();

        Item itemAtualizado = new Item(id, "Livro", "Python", "Outro Autor", 2);
        itemBO.atualizarItem(itemAtualizado);
        assertEquals("Python", itemBO.listarItens().get(0).getTitulo());
    }

    @Test
    public void testDeletarItem() throws SQLException {
        Item item = new Item(0, "Livro", "Java", "Autor", 1);
        itemBO.adicionarItem(item);
        int id = itemBO.listarItens().get(0).getId();

        itemBO.deletarItem(id);
        assertEquals(0, itemBO.listarItens().size());
    }
}