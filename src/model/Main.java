package model;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        int opcao;
        do {
            // Apresentar o menu
            System.out.println("=============================================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar Pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("=============================================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    incluirPessoa(scanner, repoFisica, repoJuridica);
                    break;
                case 2:
                    alterarPessoa(scanner, repoFisica, repoJuridica);
                    break;
                case 3:
                    excluirPessoa(scanner, repoFisica, repoJuridica);
                    break;
                case 4:
                    buscarPessoaPorId(scanner, repoFisica, repoJuridica);
                    break;
                case 5:
                    exibirTodos(scanner, repoFisica, repoJuridica);
                    break;
                case 6:
                    persistirDados(scanner, repoFisica, repoJuridica);
                    break;
                case 7:
                    recuperarDados(scanner, repoFisica, repoJuridica);
                    break;
                case 0:
                    System.out.println("Finalizando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void incluirPessoa(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("F - Pessoa Física  |  J - Pessoa Jurídica: ");
        char tipo = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Digite o Id da Pessoa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Digite o Nome: ");
        String nome = scanner.nextLine();

        if (tipo == 'F') {
            System.out.print("Digite o CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Digite a Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf, idade);
            repoFisica.inserir(pessoaFisica);
        } else if (tipo == 'J') {
            System.out.print("Digite o CNPJ: ");
            String cnpj = scanner.nextLine();

            PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
            repoJuridica.inserir(pessoaJuridica);
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void alterarPessoa(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("F - Pessoa Física  |  J - Pessoa Jurídica: ");
        char tipo = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Digite o Id da Pessoa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (tipo == 'F') {
            PessoaFisica pessoaFisica = repoFisica.obter(id);
            if (pessoaFisica != null) {
                System.out.println("Dados Atuais: " + pessoaFisica);
                System.out.print("Digite o Novo Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o Novo CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Digite a Nova Idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                pessoaFisica.setNome(nome);
                pessoaFisica.setCpf(cpf);
                pessoaFisica.setIdade(idade);
                repoFisica.alterar(pessoaFisica);
            } else {
                System.out.println("Pessoa Física não encontrada.");
            }
        } else if (tipo == 'J') {
            PessoaJuridica pessoaJuridica = repoJuridica.obter(id);
            if (pessoaJuridica != null) {
                System.out.println("Dados Atuais: " + pessoaJuridica);
                System.out.print("Digite o Novo Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o Novo CNPJ: ");
                String cnpj = scanner.nextLine();

                pessoaJuridica.setNome(nome);
                pessoaJuridica.setCnpj(cnpj);
                repoJuridica.alterar(pessoaJuridica);
            } else {
                System.out.println("Pessoa Jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void excluirPessoa(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("F - Pessoa Física  |  J - Pessoa Jurídica: ");
        char tipo = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Digite o Id da Pessoa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (tipo == 'F') {
            repoFisica.excluir(id);
        } else if (tipo == 'J') {
            repoJuridica.excluir(id);
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void buscarPessoaPorId(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("F - Pessoa Física  |  J - Pessoa Jurídica: ");
        char tipo = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Digite o Id da Pessoa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (tipo == 'F') {
            PessoaFisica pessoaFisica = repoFisica.obter(id);
            if (pessoaFisica != null) {
                System.out.println("Dados: " + pessoaFisica);
            } else {
                System.out.println("Pessoa Física não encontrada.");
            }
        } else if (tipo == 'J') {
            PessoaJuridica pessoaJuridica = repoJuridica.obter(id);
            if (pessoaJuridica != null) {
                System.out.println("Dados: " + pessoaJuridica);
            } else {
                System.out.println("Pessoa Jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void exibirTodos(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("F - Pessoa Física  |  J - Pessoa Jurídica: ");
        char tipo = scanner.nextLine().toUpperCase().charAt(0);

        if (tipo == 'F') {
            for (PessoaFisica pf : repoFisica.obterTodos()) {
                System.out.println(pf);
            }
        } else if (tipo == 'J') {
            for (PessoaJuridica pj : repoJuridica.obterTodos()) {
                System.out.println(pj);
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void persistirDados(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Digite o prefixo dos arquivos: ");
        String prefixo = scanner.nextLine();
        String arquivoFisica = prefixo + ".fisica.bin";
        String arquivoJuridica = prefixo + ".juridica.bin";

        try {
            repoFisica.persistir(arquivoFisica);
            repoJuridica.persistir(arquivoJuridica);
            System.out.println("Dados de Pessoa Física e Jurídica armazenados.");
        } catch (IOException e) {
            System.out.println("Erro ao persistir os dados: " + e.getMessage());
        }
    }

    private static void recuperarDados(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        System.out.print("Digite o prefixo dos arquivos: ");
        String prefixo = scanner.nextLine();
        String arquivoFisica = prefixo + ".fisica.bin";
        String arquivoJuridica = prefixo + ".juridica.bin";

        try {
            repoFisica.recuperar(arquivoFisica);
            repoJuridica.recuperar(arquivoJuridica);
            System.out.println("Dados de Pessoa Física e Jurídica recuperados.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
        }
    }
}
