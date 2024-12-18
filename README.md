# Biblioteca POO Java

Este é um projeto de exemplo que implementa uma aplicação de gerenciamento de biblioteca utilizando Programação Orientada a Objetos (POO) em Java. O projeto inclui classes para modelar itens de biblioteca, usuários e operações de banco de dados.

## Integrantes do Projeto

- Luiz Eduardo
- Lucas Pereira
- Klebertt
- Antony Thiago

**Professor:** Kenji Kamei  
**Disciplina:** Programação Orientada a Objetos (POO)

## Critérios de Avaliação

Os seguintes requisitos foram atendidos para avaliação do projeto:

- Uso de **POO**, incluindo classes abstratas, interfaces, herança, polimorfismo e encapsulamento.
- Estruturação do projeto em **camadas**: View, BO, VO, DAO.
- Implementação de **Collections** para manipulação eficiente de dados.
- Uso de **Testes Unitários** automatizados para validar regras de negócio e operações de banco de dados.
- Integração com banco de dados (SQLite), com suporte a operações `insert`, `update`, `delete` e `select`.
- Tratamento de erros por meio de **exceções personalizadas**.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- **src/biblioteca**: Contém os pacotes e classes principais do projeto.
  - **bo**: Classes de lógica de negócios (Business Objects).
    - `ItemBO.java`: Lógica de negócios para itens da biblioteca.
    - `UsuarioBO.java`: Lógica de negócios para usuários da biblioteca.
  - **dao**: Classes de acesso a dados (Data Access Objects).
    - `ItemDAO.java`: Acesso a dados para itens da biblioteca.
    - `UsuarioDAO.java`: Acesso a dados para usuários da biblioteca.
  - **exceptions**: Classes de exceções personalizadas.
    - `ItemNaoEncontradoException.java`: Exceção lançada quando um item não é encontrado.
    - `UsuarioNaoEncontradoException.java`: Exceção lançada quando um usuário não é encontrado.
  - **model**: Classes de modelo.
    - `Entidade.java`: Classe base para entidades.
    - `Item.java`: Representa um item da biblioteca.
    - `Persistivel.java`: Interface para entidades que podem ser persistidas.
    - `Usuario.java`: Representa um usuário da biblioteca.
  - **view**: Classes relacionadas à interface do usuário.
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

### Configurar o Ambiente

1. **Instalar o Java Development Kit (JDK)**:
   - Certifique-se de ter o JDK instalado. Você pode baixar a versão mais recente do [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) ou do [OpenJDK](https://openjdk.java.net/).
   - Configure a variável de ambiente `JAVA_HOME` apontando para o diretório de instalação do JDK.

2. **Configurar o Ambiente de Desenvolvimento**:
   - Você pode usar o IntelliJ IDEA, Eclipse, ou outra IDE de sua preferência. Certifique-se de configurar o projeto Java corretamente na IDE escolhida.

### Configurar o Banco de Dados

O projeto utiliza o SQLite como banco de dados, e para visualização e gerenciamento do banco de dados, você pode usar o SQLite Browser.

1. **Instalar o SQLite**:
   - O SQLite é uma biblioteca em C que implementa um banco de dados SQL pequeno, rápido e auto-contido. Não é necessário instalar um servidor de banco de dados separado.
   - Para instalar o SQLite, siga as instruções no site oficial: [SQLite Download Page](https://www.sqlite.org/download.html).
   - Faça o download da versão apropriada para o seu sistema operacional. A versão **sqlite-tools** contém as ferramentas necessárias.

2. **Verificar a Instalação**:
   - Após a instalação, abra o terminal ou prompt de comando e digite:
     ```bash
     sqlite3 --version
     ```
   - Isso exibirá a versão do SQLite instalada. Se tudo estiver correto, a instalação foi bem-sucedida.

### Instalar o SQLite Browser (opcional)

1. **Baixar o SQLite Browser**:
   - Acesse o site oficial do DB Browser for SQLite: [DB Browser for SQLite](https://sqlitebrowser.org/).
   - Baixe a versão apropriada para o seu sistema operacional (Windows, Mac ou Linux) e siga o processo de instalação.

2. **Usar o SQLite Browser**:
   - O DB Browser for SQLite é uma ferramenta gráfica que permite visualizar e editar bancos de dados SQLite de forma fácil e intuitiva.
   - Abra o arquivo `biblioteca.db` incluído no projeto para visualizar as tabelas e dados. Você pode também criar consultas SQL ou editar diretamente os dados.

3. **Configurar a Conexão com o Banco de Dados**:
   - A classe `ConexaoBanco.java` do projeto gerencia a conexão com o banco de dados SQLite.
   - O banco de dados é configurado para ser usado automaticamente, então não é necessário configurar nada manualmente para acessar o banco de dados SQLite.

### Inicializar o Banco de Dados

1. O arquivo `biblioteca.db` já está incluído no projeto. Caso deseje recriar o banco de dados ou inicializá-lo a partir do zero, siga os passos abaixo:
   - Execute a classe `InicializadorBanco.java` diretamente pela IDE.
   - A classe irá criar as tabelas e inserir os dados iniciais necessários para o funcionamento do sistema.

### Executar o Projeto

1. **Executar a Aplicação**:
   - Execute a classe `MenuPrincipal.java` para iniciar o sistema.
   - A aplicação vai carregar a interface de usuário, permitindo realizar operações como empréstimos e devoluções de livros, além de gerenciar os usuários e itens da biblioteca.

---

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## Licença

Este projeto está licenciado sob a licença [MIT](LICENSE).
