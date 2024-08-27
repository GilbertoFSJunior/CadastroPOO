package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> listaPessoaJuridica;

    // Construtor da classe inicializando a lista
    public PessoaJuridicaRepo() {
        listaPessoaJuridica = new ArrayList<>();
    }

    // Método para inserir uma nova PessoaJuridica no repositório
    public void inserir(PessoaJuridica pj) {
        listaPessoaJuridica.add(pj);
    }

    // Método para alterar uma PessoaJuridica existente no repositório
    public void alterar(PessoaJuridica pj) {
        for (int i = 0; i < listaPessoaJuridica.size(); i++) {
            if (listaPessoaJuridica.get(i).getId() == pj.getId()) {
                listaPessoaJuridica.set(i, pj);
                break;
            }
        }
    }

    // Método para excluir uma PessoaJuridica do repositório pelo id
    public void excluir(int id) {
        listaPessoaJuridica.removeIf(pj -> pj.getId() == id);
    }

    // Método para obter uma PessoaJuridica pelo id
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pj : listaPessoaJuridica) {
            if (pj.getId() == id) {
                return pj;
            }
        }
        return null; // Retorna null se não encontrar a PessoaJuridica
    }

    // Método para obter todas as PessoaJuridica no repositório
    public ArrayList<PessoaJuridica> obterTodos() {
        return listaPessoaJuridica;
    }

    // Método para persistir os dados no disco
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(listaPessoaJuridica);
        }
    }

    // Método para recuperar os dados do disco
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPessoaJuridica = (ArrayList<PessoaJuridica>) ois.readObject();
        }
    }
}
