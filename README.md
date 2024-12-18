# Biblioteca POO Java

Este é um projeto de exemplo que implementa uma aplicação de gerenciamento de biblioteca utilizando Programação Orientada a Objetos (POO) em Java. O projeto inclui classes para modelar itens de biblioteca, usuários, e operações de banco de dados.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- **src/biblioteca**: Contém os pacotes e classes principais do projeto.
  - **bo**: Contém as classes de lógica de negócios (Business Objects).
    - `ItemBO.java`: Lógica de negócios para itens da biblioteca.
    - `UsuarioBO.java`: Lógica de negócios para usuários da biblioteca.
  - **dao**: Contém as classes de acesso a dados (Data Access Objects).
    - `ItemDAO.java`: Acesso a dados para itens da biblioteca.
    - `UsuarioDAO.java`: Acesso a dados para usuários da biblioteca.
  - **exceptions**: Contém as classes de exceções personalizadas.
    - `ItemNaoEncontradoException.java`: Exceção lançada quando um item não é encontrado.
    - `UsuarioNaoEncontradoException.java`: Exceção lançada quando um usuário não é encontrado.
  - **model**: Contém as classes de modelo.
    - `Entidade.java`: Classe base para entidades.
    - `Item.java`: Representa um item da biblioteca.
    - `Persistivel.java`: Interface para entidades que podem ser persistidas.
    - `Usuario.java`: Representa um usuário da biblioteca.
  - **view**: Contém as classes relacionadas à interface do usuário.
    - `ConexaoBanco.java`: Classe para gerenciar conexões com o banco de dados.
    - `InicializadorBanco.java`: Classe para inicializar o banco de dados.

- **test**: Contém os testes unitários para as classes do projeto.
  - `ItemBOTest.java`: Testes para a classe `ItemBO`.
  - `ItemDAOTest.java`: Testes para a classe `ItemDAO`.
  - `UsuarioBOTest.java`: Testes para a classe `UsuarioBO`.
  - `UsuarioDAOTest.java`: Testes para a classe `UsuarioDAO`.

- **lib**: Contém as bibliotecas externas utilizadas no projeto.
  - `sqlite-jdbc-3.47.1.0.jar`: Driver JDBC para SQLite.

- **biblioteca.db**: Arquivo do banco de dados SQLite.

- **.idea**: Diretório de configuração do IntelliJ IDEA.
  - `misc.xml`: Configurações diversas do projeto.
  - `modules.xml`: Configurações de módulos do projeto.
  - `vcs.xml`: Configurações de controle de versão.
  - `biblioteca_POO_java.iml`: Arquivo de configuração do módulo do projeto.

- **.gitignore**: Arquivo para ignorar arquivos e diretórios no controle de versão.

- **.vscode**: Diretório de configuração do Visual Studio Code.
  - `launch.json`: Configurações de execução e depuração no VS Code.

## Como Executar o Projeto

1. **Configurar o Ambiente**:
   - Certifique-se de ter o Java Development Kit (JDK) instalado.
   - Configure o ambiente de desenvolvimento (IntelliJ IDEA ou outra IDE de sua preferência).

2. **Configurar o Banco de Dados**:
   - O projeto utiliza SQLite como banco de dados. O arquivo `biblioteca.db` já está incluído no projeto, mas você pode inicializá-lo novamente usando a classe `InicializadorBanco.java`.

3. **Executar o Projeto**:
   - Execute a classe `MenuPrincipal.java` para iniciar o sistema.

## Dependências

- **SQLite JDBC**: O projeto utiliza o driver JDBC para SQLite (`sqlite-jdbc-3.47.1.0.jar`). Certifique-se de que ele está incluído no classpath do projeto.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## Licença

Este projeto está licenciado sob a licença [MIT](LICENSE).
