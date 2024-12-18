package biblioteca;

import java.sql.Connection;
import java.sql.Statement;

public class InicializadorBanco {
    public static void inicializar() {
        String criarTabelaItens = "CREATE TABLE IF NOT EXISTS Itens (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tipo TEXT, " +
                "titulo TEXT, " +
                "autor TEXT, " +
                "edicao INTEGER)";

        String criarTabelaUsuarios = "CREATE TABLE IF NOT EXISTS Usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, " +
                "matricula TEXT)";

        try (Connection conexao = ConexaoBanco.conectar();
             Statement stmt = conexao.createStatement()) {
            stmt.execute(criarTabelaItens);
            stmt.execute(criarTabelaUsuarios);
            System.out.println("Tabelas criadas com sucesso no SQLite!");
        } catch (Exception e) {
            System.err.println("Erro ao inicializar banco SQLite: " + e.getMessage());
        }
    }
}
