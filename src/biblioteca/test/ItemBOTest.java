package biblioteca.test;

import biblioteca.bo.ItemBO;
import biblioteca.model.Item;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ItemBOTest {

    @Test
    public void testAdicionarItem() throws SQLException {
        ItemBO itemBO = new ItemBO();
        Item item = new Item(0, "Livro", "Java", "Autor", 1);
        itemBO.adicionarItem(item);
        assertEquals(1, itemBO.listarItens().size());
    }
}