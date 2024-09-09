# Cadastro de Clientes em Java

## Descrição do Projeto

Este projeto consiste na implementação de um sistema de cadastro de clientes utilizando a linguagem Java. O sistema permite o cadastro de pessoas físicas e jurídicas, com persistência dos dados em arquivos binários. A implementação foi desenvolvida como parte da missão prática do curso "Iniciando o caminho pelo Java" (RPG0014).

## Objetivos do projeto

- Utilizar herança e polimorfismo na definição de entidades.
- Implementar a persistência de objetos em arquivos binários.
- Criar uma interface cadastral em modo texto.
- Utilizar o controle de exceções da plataforma Java.

No final do projeto, espera-se que o aluno tenha implementado um sistema cadastral completo, utilizando os recursos da programação orientada a objetos e persistência em arquivos binários.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes e pacotes:

### Pacote `model`
- **Classe `Pessoa`**: 
  - Campos: `id` (inteiro) e `nome` (texto)
  - Métodos: `exibir`, `getters` e `setters`, construtores padrão e completo
- **Classe `PessoaFisica`** (herda de `Pessoa`):
  - Campos: `cpf` (texto) e `idade` (inteiro)
  - Métodos: `exibir` (polimórfico), `getters` e `setters`, construtores
- **Classe `PessoaJuridica`** (herda de `Pessoa`):
  - Campo: `cnpj` (texto)
  - Métodos: `exibir` (polimórfico), `getters` e `setters`, construtores
- **Interface `Serializable`**: Implementada em todas as classes para permitir a persistência em arquivos.

### Pacote `model` (gerenciadores)
- **Classe `PessoaFisicaRepo`**:
  - Armazena objetos `PessoaFisica` em um `ArrayList`
  - Métodos: `inserir`, `alterar`, `excluir`, `obter`, `obterTodos`, `persistir`, `recuperar`
- **Classe `PessoaJuridicaRepo`**:
  - Armazena objetos `PessoaJuridica` em um `ArrayList`
  - Métodos: `inserir`, `alterar`, `excluir`, `obter`, `obterTodos`, `persistir`, `recuperar`

### Pacote Principal
- **Classe `Main`**:
  - Implementa a interface de cadastro em modo texto, permitindo operações como incluir, alterar, excluir, obter, salvar e recuperar dados.

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

1. **Incluir**: Cadastrar novas pessoas físicas ou jurídicas.
2. **Alterar**: Modificar dados de um cliente já cadastrado.
3. **Excluir**: Remover clientes do cadastro.
4. **Obter**: Buscar informações de um cliente específico pelo ID.
5. **Obter Todos**: Listar todos os clientes cadastrados.
6. **Salvar Dados**: Persistir os dados dos clientes em arquivos binários.
7. **Recuperar Dados**: Carregar os dados dos clientes a partir de arquivos binários.
8. **Sair**: Finalizar a execução do sistema.

## Requisitos

- **JDK** (Java Development Kit) e **NetBeans IDE** instalados.

## Como Executar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone [https://github.com/GilbertoFSJunior/CadastroPOO]
