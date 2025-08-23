package main.java.map.Ordenacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class LivrariaOnline {
    //atributo
    Map<String, Livro> livrosMap;

    public LivrariaOnline() {
        this.livrosMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        livrosMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo) {
        List<String> chavesParaRemover = new ArrayList<>();
        if(!livrosMap.isEmpty()) {
            for(Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
                if(entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    chavesParaRemover.add(entry.getKey());
                }
            }
        } else {
            throw new RuntimeException("Não há livros no acervo online.");
        }
        if(!chavesParaRemover.isEmpty()) {
            for(String chave : chavesParaRemover) {
                livrosMap.remove(chave);
            }
        } else {
            throw new RuntimeException("Não há livros com esse título.");
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        if(livrosMap.isEmpty()) {
            throw new RuntimeException("Não há livros no acervo online!");
        }

        // Cria uma lista de objetos Map.Entry<K,V>
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livrosMap.entrySet());

        // Ordena a lista usando um Comparator<Map.Entry<K,V>>
        livrosParaOrdenarPorPreco.sort(new ComparatorPorPreco());

        // Instanciado como LinkedHashMap para preservar a inserção
        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for(Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
        if(livrosMap.isEmpty()) {
            throw new RuntimeException("Não há livros no acervo online!");
        }

        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livrosMap.entrySet());

        livrosParaOrdenarPorAutor.sort(new ComparatorPorAutor());

        Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

        for(Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
            livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorAutor;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        if(livrosMap.isEmpty()) {
            throw new RuntimeException("Não há livros no acervo online!");
        }

        Map<String, Livro> livrosPorAutor = new HashMap<>();
        for(Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            if(entry.getValue().getAutor().equalsIgnoreCase(autor)) {
                livrosPorAutor.put(entry.getKey(), entry.getValue());
            }
        }
        if(!livrosPorAutor.isEmpty()) {
            return livrosPorAutor;
        } else {
            throw new RuntimeException("Não há livros desse autor!");
        }
    }

    public List<Livro> obterLivroMaisCaro() {
        List<Livro> livrosMaisCaros = new ArrayList<>();
        double maiorPreco = Double.MIN_VALUE;

        if(!livrosMap.isEmpty()) {
            for(Livro livro : livrosMap.values()) {
                if(livro.getPreco() > maiorPreco) {
                    maiorPreco = livro.getPreco();
                }
            }
        } else {
            throw new NoSuchElementException("Não há livros no acervo online!");
        }

        for(Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            if(entry.getValue().getPreco() == maiorPreco) {
                livrosMaisCaros.add(entry. getValue());
            }
        }
        return livrosMaisCaros;
    }

    public List<Livro> obterLivroMaisBarato() {
        List<Livro> livrosMaisBaratos = new ArrayList<>();
        double menorPreco = Double.MAX_VALUE;

        if(!livrosMap.isEmpty()) {
            for(Livro livro : livrosMap.values()) {
                if(livro.getPreco() < menorPreco) {
                    menorPreco = livro.getPreco();
                }
            }
        } else {
            throw new NoSuchElementException("Não há livros no acervo online!");
        }

        for(Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            if(entry.getValue().getPreco() == menorPreco) {
                livrosMaisBaratos.add(entry. getValue());
            }
        }
        return livrosMaisBaratos;
    }

    public static void main(String[] args) {
        LivrariaOnline livraria = new LivrariaOnline();

        /* Exibe livraria vazia
        System.out.println(livraria.exibirLivrosOrdenadosPorPreco());*/

        // Adiciona novos livros à livraria
        livraria.adicionarLivro("livro1.com", "Livro 1", "Autor 1", 199.90);
        livraria.adicionarLivro("livro2.com", "Livro 2", "Autor 2", 159.90);
        livraria.adicionarLivro("livro3.com", "Livro 3", "Autor 3", 139.90);
        livraria.adicionarLivro("livro4.com", "Livro 4", "Autor 4", 99.90);
        livraria.adicionarLivro("livro5.com", "Livro 5", "Autor 5", 59.90);
        livraria.adicionarLivro("livro6.com", "Livro 6", "Autor 6", 199.90);

        // Ordena livros por preço e exibe
        System.out.println(livraria.exibirLivrosOrdenadosPorPreco());

        // Ordena livros por autor e exibe
        System.out.println(livraria.exibirLivrosOrdenadosPorAutor());

        // Remove um livro
        livraria.removerLivro("Livro 2");

        // Obtém e exibe livros mais caros
        System.out.println(livraria.obterLivroMaisCaro());

        // Obtém e exibe livros mais baratos
        System.out.println(livraria.obterLivroMaisBarato());
    }
}
