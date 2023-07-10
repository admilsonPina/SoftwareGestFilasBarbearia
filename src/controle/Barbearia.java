package controle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Agendamento;
import modelo.Barbeiro;
import modelo.Cliente;
import modelo.Cortes;

public class Barbearia {
    private HashMap<Barbeiro, FilaAtendimento> filas;
    private Map<Barbeiro, Integer> senhas;
    private List<Agendamento> agendamentosFinalizados;

    public Barbearia() {
        filas = new HashMap<>();
        senhas = new HashMap<>();
        agendamentosFinalizados = new ArrayList<>();
    }

    public void agendarCliente(Cliente cliente, LocalDateTime dataHora, Cortes corte, Barbeiro barbeiro, String status, String senha) {
    	FilaAtendimento fila = filas.getOrDefault(barbeiro, new FilaAtendimento());
		Agendamento agendamento = new Agendamento(cliente, dataHora, corte, barbeiro, status, senha);
		fila.enqueue(agendamento);
        filas.put(barbeiro, fila);
        BaseDeDados.inserirAgendamento(agendamento);
        
    }
    
    public void receberAgendamento(Agendamento agendamento, Barbeiro barbeiro) {
        FilaAtendimento fila = filas.getOrDefault(barbeiro, new FilaAtendimento());
        fila.enqueue(agendamento);
        filas.put(barbeiro, fila);   
    }
    

    
    public Agendamento atenderProximoCliente(Barbeiro barbeiro) {
        FilaAtendimento fila = filas.get(barbeiro);
        if (fila != null) {
            Agendamento agendamento = fila.dequeue();
            if (fila.isEmpty()) {
                filas.remove(barbeiro);
            }
            return agendamento;
        }
        return null;
    }
    

    public void exibirFila(Barbeiro barbeiro) {
        FilaAtendimento fila = filas.get(barbeiro);
        if (fila != null) {
            fila.exibirFila();
        }
    }
    
    public void limparFila(Barbeiro barbeiro) {
        FilaAtendimento fila = filas.get(barbeiro);
        if (fila != null && !fila.isEmpty()) {
            Agendamento agendamento = fila.dequeue();
            System.out.println("Agendamento finalizado:");
            System.out.println("Cliente: " + agendamento.getCliente().getNome());
            System.out.println("Barbeiro: " + barbeiro.getNome());
            System.out.println("Tipo de Corte: " + agendamento.getCorte().getTipoCorte());
            System.out.println("Data/Hora: " + agendamento.getDataHora());

            // Atualizar a lista de agendamentos finalizados
            agendamentosFinalizados.add(agendamento); 
        } else {
            System.out.println("A fila do barbeiro " + barbeiro.getNome() + " está vazia.");
        }
    }
    public FilaAtendimento getFila(Barbeiro barbeiro) {
        return filas.get(barbeiro);
    }


    public int getTamanho(Barbeiro barbeiro) {
        FilaAtendimento fila = filas.get(barbeiro);
        if (fila != null) {
            return fila.getTamanho();
        }
        return 0;
    }

    public void atualizarTamanhoFila(Barbeiro barbeiro) {
        FilaAtendimento fila = filas.get(barbeiro);
        if (fila != null) {
            fila.atualizarTamanho();
        }
    }

    public Agendamento getUltimoAgendamento(Barbeiro barbeiro) {
        FilaAtendimento fila = filas.get(barbeiro);
        if (fila != null) {
            return fila.getUltimoAgendamento();
        }
        return null;
    }
    
    public Agendamento getPrimeiroAgendamento(Barbeiro barbeiro) {
        FilaAtendimento fila = filas.get(barbeiro);
        if (fila != null && !fila.isEmpty()) {
            return fila.getPrimeiroAgendamento();
        }
        return null;
    }
    public boolean temSenha(Barbeiro barbeiro) {
        return senhas.containsKey(barbeiro);
    }

    public void inicializarSenha(Barbeiro barbeiro) {
        senhas.put(barbeiro, 1); // Define o valor padrão da senha como 1
    }

    public String getSenhaAtual(Barbeiro barbeiro) {
        if (temSenha(barbeiro)) {
            int senha = senhas.get(barbeiro);
            return gerarSenhaFormatada(senha,barbeiro);
        }
        return null;
    }

    public void incrementarSenha(Barbeiro barbeiro) {
        if (temSenha(barbeiro)) {
            int senhaAtual = senhas.get(barbeiro);
            senhas.put(barbeiro, senhaAtual + 1);
        }
    }

    private String gerarSenhaFormatada(int senha, Barbeiro barbeiro) {
        String pLB = String.valueOf(barbeiro.getNome().charAt(0)).toUpperCase();
        return pLB + String.format("%03d", senha);
    }
    public Barbeiro getBarbeiroComMenorHorario() {
        Barbeiro barbeiroComMenorHorario = null;
        LocalDateTime menorHorario = null;

        for (Barbeiro barbeiro : filas.keySet()) {
            FilaAtendimento fila = filas.get(barbeiro);
            if (fila != null && !fila.isEmpty()) {
                Agendamento agendamento = fila.getPrimeiroAgendamento();
                LocalDateTime horarioAgendamento = agendamento.getDataHora();

                if (menorHorario == null || horarioAgendamento.isBefore(menorHorario)) {
                    menorHorario = horarioAgendamento;
                    barbeiroComMenorHorario = barbeiro;
                }
            }
        }

        return barbeiroComMenorHorario;
    }

}

