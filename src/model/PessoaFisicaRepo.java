package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> listaPessoaFisica;

    
    public PessoaFisicaRepo() {
        listaPessoaFisica = new ArrayList<>();
    }

    
    public void inserir(PessoaFisica pf) {
        listaPessoaFisica.add(pf);
    }

    
    public void alterar(PessoaFisica pf) {
        for (int i = 0; i < listaPessoaFisica.size(); i++) {
            if (listaPessoaFisica.get(i).getId() == pf.getId()) {
                listaPessoaFisica.set(i, pf);
                break;
            }
        }
    }

    
    public void excluir(int id) {
        listaPessoaFisica.removeIf(pf -> pf.getId() == id);
    }

    
    public PessoaFisica obter(int id) {
        for (PessoaFisica pf : listaPessoaFisica) {
            if (pf.getId() == id) {
                return pf;
            }
        }
        return null; 
    }

    
    public ArrayList<PessoaFisica> obterTodos() {
        return listaPessoaFisica;
    }

    
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(listaPessoaFisica);
        }
    }

    
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPessoaFisica = (ArrayList<PessoaFisica>) ois.readObject();
        }
    }
}
