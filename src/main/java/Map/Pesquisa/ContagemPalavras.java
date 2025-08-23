package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    //atributo
    private Map<String, Integer> contagemPalavrasMap;

    public ContagemPalavras() {
        this.contagemPalavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, int contagem) {
        contagemPalavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if(!contagemPalavrasMap.isEmpty()) {
            contagemPalavrasMap.remove(palavra);
        } else {
            System.out.println("Não há nenhuma palavra na contagem!");
        }
    }

    public void exibirContagemPalavras() {
        if(!contagemPalavrasMap.isEmpty()) {
            System.out.println(contagemPalavrasMap);
        } else {
            System.out.println("Não há nenhuma palavra na contagem!");
        }
    }

    public String encontrarPalavraMaisFrenquente() {
        String palavraMaisFrequente = null;
        int maiorContagem = 0;
        if(!contagemPalavrasMap.isEmpty()) {
            // Itera sobre cada palavra da coleção (utiliza keySet() para iterar sobre as chaves do Map)
            for(String palavra : contagemPalavrasMap.keySet()) {
                int contagemPalavraAtual = contagemPalavrasMap.get(palavra);
                if(contagemPalavraAtual > maiorContagem) {
                    maiorContagem = contagemPalavraAtual;
                    palavraMaisFrequente = palavra;
                }
            }
        } else {
            System.out.println("Não há nenhuma palavra na contagem!");
        }
        return palavraMaisFrequente;
    }
}
