package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    //atributo
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;
        if(!tarefaSet.isEmpty()) {
            for(Tarefa t : tarefaSet) {
                if(t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover = t;
                    break;
                }
            }
            tarefaSet.remove(tarefaParaRemover);
        } else {
            throw new RuntimeException("O conjunto está vazio.");
        }

        if(tarefaParaRemover == null) {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void exibirTarefas() {
        if(!tarefaSet.isEmpty()) {
            System.out.println(tarefaSet);
        } else {
            System.out.println("A lista de tarefas está vazia.");
        }
    }

    public int contarTarefas() {
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if(!tarefaSet.isEmpty()) {
            for(Tarefa t : tarefaSet) {
                if(t.isConcluida()) {
                    tarefasConcluidas.add(t);
                }
            }
            return tarefasConcluidas;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if(!tarefaSet.isEmpty()) {
            for(Tarefa t : tarefaSet) {
                if(!t.isConcluida()) {
                    tarefasPendentes.add(t);
                }
            }
            return tarefasPendentes;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public void marcarTarefaConcluida(String descricao) {
        Tarefa tarefaConluida = null;
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluida(true);
                    tarefaConluida = t;
                    break;
                }
            }
        } else {
            throw new RuntimeException("O conjunto está vazio.");
        }
    }

    public void marcarTarefaPendente(String descricao) {
        Tarefa tarefaParaMarcarComoPendente = null;
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaMarcarComoPendente = t;
                    break;
                }
            }

            if(tarefaParaMarcarComoPendente != null) {
                if(tarefaParaMarcarComoPendente.isConcluida()) {
                    tarefaParaMarcarComoPendente.setConcluida(false);
                }
            }
        } else {
            throw new RuntimeException("O conjunto está vazio.");
        }
    }

    public void limparListaTarefas() {
        if(!tarefaSet.isEmpty()) {
            tarefaSet.clear();
        } else {
            System.out.println("A lista de tarefas já está vazia!");
        }
    }
}
