package biblioteca.view;

import biblioteca.dao.ItemDAO;
import biblioteca.dao.UsuarioDAO;
import biblioteca.model.Item;
import biblioteca.model.Usuario;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ItemDAO itemDAO = new ItemDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Adicionar Item");
            System.out.println("2. Listar Itens");
            System.out.println("3. Atualizar Item");
            System.out.println("4. Deletar Item");
            System.out.println("5. Adicionar Usuário");
            System.out.println("6. Listar Usuários");
            System.out.println("7. Atualizar Usuário");
            System.out.println("8. Deletar Usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Tipo: ");
                        String tipo = scanner.nextLine();
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();
                        System.out.print("Edição: ");
                        int edicao = scanner.nextInt();
                        itemDAO.adicionarItem(new Item(0, tipo, titulo, autor, edicao));
                        break;
                    case 2:
                        List<Item> itens = itemDAO.listarItens();
                        itens.forEach(item -> System.out.println(item.getId() + " - " + item.getTitulo()));
                        break;
                    case 3:
                        System.out.print("ID do Item: ");
                        int idItem = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Novo Título: ");
                        String novoTitulo = scanner.nextLine();
                        itemDAO.atualizarItem(new Item(idItem, null, novoTitulo, null, 0));
                        break;
                    case 4:
                        System.out.print("ID do Item: ");
                        int idDelete = scanner.nextInt();
                        itemDAO.deletarItem(idDelete);
                        break;
                    case 5:
                        System.out.print("Nome do Usuário: ");
                        String nome = scanner.nextLine();
                        System.out.print("Matrícula: ");
                        String matricula = scanner.nextLine();
                        usuarioDAO.adicionarUsuario(new Usuario(0, nome, matricula));
                        break;
                    case 6:
                        List<Usuario> usuarios = usuarioDAO.listarUsuarios();
                        usuarios.forEach(usuario -> System.out.println(usuario.getId() + " - " + usuario.getNome()));
                        break;
                    case 7:
                        System.out.print("ID do Usuário: ");
                        int idUsuario = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Novo Nome: ");
                        String novoNome = scanner.nextLine();
                        usuarioDAO.atualizarUsuario(new Usuario(idUsuario, novoNome, null));
                        break;
                    case 8:
                        System.out.print("ID do Usuário: ");
                        int idUsuarioDelete = scanner.nextInt();
                        usuarioDAO.deletarUsuario(idUsuarioDelete);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (SQLException e) {
                System.err.println("Erro no banco de dados: " + e.getMessage());
            }
        }
    }
}