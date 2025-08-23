package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    //atributo
    Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        eventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        if(!eventosTreeMap.isEmpty()) {
            System.out.println(eventosTreeMap);
        } else {
            throw new RuntimeException("O Map está vazio!");
        }
    }

    public Evento obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        Evento proximoEvento = null;

        // Ordena o Map em ordem crescente e itera sobre ele
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            LocalDate dataEvento = entry.getKey();
            if(dataEvento.isEqual(dataAtual) || dataEvento.isAfter(dataAtual)) {
                proximoEvento = entry.getValue();
                break;
            }
        }
        if(proximoEvento != null) return proximoEvento;
        else throw new RuntimeException("Não há eventos futuros na agenda");
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        // Adiciona eventos à agenda
        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Evento 1", "Atração 1");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Evento 2", "Atração 2");
        agendaEventos.adicionarEvento(LocalDate.of(2020, Month.FEBRUARY, 25), "Evento 3", "Atração 3");
        agendaEventos.adicionarEvento(LocalDate.of(2025, Month.SEPTEMBER, 22), "Evento 4", "Atração 4");
        agendaEventos.adicionarEvento(LocalDate.of(2025, Month.SEPTEMBER, 30), "Evento 4", "Atração 4");
        agendaEventos.adicionarEvento(LocalDate.of(2026, Month.APRIL, 12), "Evento 4", "Atração 4");

        // Exibe a agenda completa de eventos
        agendaEventos.exibirAgenda();

        // Obtém e exibe o próximo evento na agenda
        System.out.println("Próximo evento: " + agendaEventos.obterProximoEvento());
    }
}
