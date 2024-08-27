package model;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Nome dos arquivos para persistência
        String arquivoPessoaFisica = "pessoas_fisicas.bin";
        String arquivoPessoaJuridica = "pessoas_juridicas.bin";

        // Criar repositórios
        PessoaFisicaRepo repoPessoaFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPessoaJuridica = new PessoaJuridicaRepo();

        // Adicionar pessoas físicas
        PessoaFisica pf1 = new PessoaFisica(1, "Ana", "11111111111", 25);
        PessoaFisica pf2 = new PessoaFisica(2, "Carlos", "22222222222", 52);

        repoPessoaFisica.inserir(pf1);
        repoPessoaFisica.inserir(pf2);

        // Persistir pessoas físicas
        try {
            repoPessoaFisica.persistir(arquivoPessoaFisica);
            System.out.println("Dados de Pessoa Física Armazenados.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Recuperar e exibir pessoas físicas
        try {
            PessoaFisicaRepo repoPessoaFisicaRecuperado = new PessoaFisicaRepo();
            repoPessoaFisicaRecuperado.recuperar(arquivoPessoaFisica);
            System.out.println("Dados de Pessoa Física Recuperados.");
            for (PessoaFisica pf : repoPessoaFisicaRecuperado.obterTodos()) {
                pf.exibir();
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Adicionar pessoas jurídicas
        PessoaJuridica pj1 = new PessoaJuridica(3, "XPTO Sales", "444444444444444");
        PessoaJuridica pj2 = new PessoaJuridica(4, "XPTO Solutions", "333333333333333");

        repoPessoaJuridica.inserir(pj1);
        repoPessoaJuridica.inserir(pj2);

        // Persistir pessoas jurídicas
        try {
            repoPessoaJuridica.persistir(arquivoPessoaJuridica);
            System.out.println("Dados de Pessoa Jurídica Armazenados.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Recuperar e exibir pessoas jurídicas
        try {
            PessoaJuridicaRepo repoPessoaJuridicaRecuperado = new PessoaJuridicaRepo();
            repoPessoaJuridicaRecuperado.recuperar(arquivoPessoaJuridica);
            System.out.println("Dados de Pessoa Jurídica Recuperados.");
            for (PessoaJuridica pj : repoPessoaJuridicaRecuperado.obterTodos()) {
                pj.exibir();
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
