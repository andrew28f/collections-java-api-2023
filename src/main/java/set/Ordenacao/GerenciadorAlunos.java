package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    //atributo
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double media) {
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        Aluno alunoParaRemover = null;
        if(!alunoSet.isEmpty()) {
            for(Aluno a : alunoSet) {
                if(a.getMatricula() == matricula) {
                    alunoParaRemover = a;
                    break;
                }
            }
            alunoSet.remove(alunoParaRemover);
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }

        if(alunoParaRemover != null) {
            System.out.println("Matrícula não encontrada!");
        }
    }

    public Set<Aluno> exibirAlunosPorNome() {
        Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
        if(!alunoSet.isEmpty()) {
            return alunosPorNome;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosPorNome = new TreeSet<>(new ComparatorPorNota());
        if(!alunoSet.isEmpty()) {
            alunosPorNome.addAll(alunoSet);
            return alunosPorNome;
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public void exibirAlunos() {
        System.out.println(alunoSet);
    }

}
