package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    //atributo
    Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        estoqueProdutosMap.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos() {
        if(!estoqueProdutosMap.isEmpty()) {
            System.out.println(estoqueProdutosMap);
        } else {
            System.out.println("O estoque está vazio!");
        }
    }

    public Double calcularValorTotalEstoque() {
        double valorTotal = 0d;
        if(!estoqueProdutosMap.isEmpty()) {
            for(Produto p : estoqueProdutosMap.values()) {
                valorTotal += p.getQuantidade() * p.getPreco();
            }
        } else {
            System.out.println("O estoque está vazio!");
        }
        return valorTotal;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if(!estoqueProdutosMap.isEmpty()) {
            for(Produto p : estoqueProdutosMap.values()) {
                if(p.getPreco() > maiorPreco) {
                    maiorPreco = p.getPreco();
                    produtoMaisCaro = p;
                }
            }
        } else {
            System.out.println("O estoque está vazio!");
        } return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if(!estoqueProdutosMap.isEmpty()) {
            for(Produto p : estoqueProdutosMap.values()) {
                if(p.getPreco() < menorPreco) {
                    menorPreco = p.getPreco();
                    produtoMaisBarato = p;
                }
            }
        } else {
            System.out.println("O estoque está vazio!");
        } return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorValorTotalEstoque() {
        Produto produtoMaiorValor = null;
        double maiorValor = Double.MIN_VALUE;
        if(!estoqueProdutosMap.isEmpty()) {
            for(Produto p : estoqueProdutosMap.values()) {
                double valorProdutoEmEstoque = p.getPreco() * p.getQuantidade();
                if(valorProdutoEmEstoque > maiorValor) {
                    maiorValor = valorProdutoEmEstoque;
                    produtoMaiorValor = p;
                }
            }
        } else {
            System.out.println("O estoque está vazio!");
        }
        return produtoMaiorValor;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        // Exibe o estoque vazio
        estoque.exibirProdutos();

        // Adiciona produtos no estoque
        estoque.adicionarProduto(1L, "Produto A", 10, 5.0);
        estoque.adicionarProduto(2L, "Produto B", 3, 10.0);
        estoque.adicionarProduto(3L, "Produto C", 2, 15.0);

        // Exibe produtos no estoque
        estoque.exibirProdutos();

        // Calcula valor total do estoque
        System.out.println("Valor total do estoque: R$ " + estoque.calcularValorTotalEstoque());

        // Exibe o produto mais caro
        System.out.println("Produto mais caro: " + estoque.obterProdutoMaisCaro());

        // Exibe o produto mais barato
        System.out.println("Produto mais barato: " + estoque.obterProdutoMaisBarato());

        // Exibe o produto com a maior quantidade em valor no estoque
        System.out.println("Produto com maior quantidade em valor no estoque: " + estoque.obterProdutoMaiorValorTotalEstoque());
    }
}
