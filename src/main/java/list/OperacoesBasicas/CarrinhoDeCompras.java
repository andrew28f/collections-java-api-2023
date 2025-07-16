package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    //atributos
    private List<Item> listaItens;

    public CarrinhoDeCompras() {
        this.listaItens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        listaItens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        for (Item i : listaItens) {
            if (i.getNome().equalsIgnoreCase(nome)) {
                itensParaRemover.add(i);
            }
        }
        listaItens.removeAll(itensParaRemover);
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Item i : listaItens) {
            valorTotal += (i.getPreco() * i.getQuantidade());
        }
        return valorTotal;
    }

    public void exibirItens() {
        System.out.println(listaItens);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.adicionarItem("Maçã", 2.50, 5);
        carrinhoDeCompras.adicionarItem("Barra de chocolate", 5.25, 2);
        carrinhoDeCompras.adicionarItem("Pera", 3, 3);
        carrinhoDeCompras.exibirItens();
        System.out.println("Valor total do carrinho: " + carrinhoDeCompras.calcularValorTotal());

    }
}
