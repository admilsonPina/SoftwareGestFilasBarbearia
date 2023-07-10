package controle;

import java.util.ArrayList;
import java.util.List;
import modelo.Agendamento;
import modelo.No;

public class FilaAtendimento {
    private No inicio;
    private No fim;
    private int tamanho;

    public FilaAtendimento() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }
    public No getFim() {
		return fim;
	}
    
    public Agendamento getPrimeiroAgendamento() {
        return inicio != null ? inicio.getAgendamento() : null;
    }
    
    public Agendamento getUltimoAgendamento() {
        return fim != null ? fim.getAgendamento() : null;
    }
    public boolean isEmpty() {
        return inicio == null;
    }

    public void enqueue(Agendamento agendamento) {
        No novoNo = new No(agendamento);

        if (isEmpty()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            fim = novoNo;
        }

        tamanho++;
    }

    public Agendamento dequeue() {
        if (isEmpty()) {
            return null;
        }

        Agendamento agendamento = inicio.getAgendamento();
        inicio = inicio.getProximo();

        if (inicio == null) {
            fim = null;
        }

        tamanho--;

        return agendamento;
    }

    public void exibirFila() {
        if (isEmpty()) {
            System.out.println("Fila vazia");
            return;
        }

        No atual = inicio;

        while (atual != null) {
            System.out.println(atual.getAgendamento().getCliente().getNome());
            atual = atual.getProximo();
        }
    }

	public void atualizarTamanho() {
        int tamanho = 0;
        No atual = inicio;

        while (atual != null) {
            tamanho++;
            atual = atual.getProximo();
        }

        this.tamanho = tamanho;
    }
	
	public List<Agendamento> getAgendamentos() {
        List<Agendamento> agendamentos = new ArrayList<>();
        No atual = inicio;
        while (atual != null) {
            agendamentos.add(atual.getAgendamento());
            atual = atual.getProximo();
        }
        return agendamentos;
    }
}
