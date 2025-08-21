package main.java.set.Ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Produto implements Comparable<Produto> {
    //atributos
    private String nome;
    private long cod;
    private double preco;
    private int quantidade;

    public Produto(long cod, String nome, double preco, int quantidade) {
        this.cod = cod;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public int compareTo(Produto produto) {
        return nome.compareToIgnoreCase(produto.getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return cod == produto.cod;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cod);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", cod=" + cod +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}

class ComparatorPorPreco implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}
