package main.java.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    //atributos
    private List<Integer> integerList;

    public OrdenacaoNumeros() {
        this.integerList = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        integerList.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> inteirosAscendente = new ArrayList<>(integerList);
        Collections.sort(inteirosAscendente);
        return inteirosAscendente;
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> inteirosDescendente = new ArrayList<>(integerList);
        inteirosDescendente.sort(Collections.reverseOrder());
        return inteirosDescendente;
    }

    @Override
    public String toString() {
        return "OrdenacaoNumeros{" +
                "integerList=" + integerList +
                '}';
    }

    public static void main(String[] args) {
        // Criando uma instância da classe OrdenacaoNumeros
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

        // Adicionando números à lista
        ordenacaoNumeros.adicionarNumero(50);
        ordenacaoNumeros.adicionarNumero(10);
        ordenacaoNumeros.adicionarNumero(20);
        ordenacaoNumeros.adicionarNumero(35);
        ordenacaoNumeros.adicionarNumero(30);
        ordenacaoNumeros.adicionarNumero(45);

        // Imprimindo a lista
        System.out.println(ordenacaoNumeros);

        // Ordenando e imprimindo a lista em ordem ascendente
        System.out.println(ordenacaoNumeros.ordenarAscendente());

        // Ordenando e imprimindo a lista em ordem descendente
        System.out.println(ordenacaoNumeros.ordenarDescendente());
    }
}
