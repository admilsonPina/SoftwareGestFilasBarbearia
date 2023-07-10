package modelo;

import java.time.LocalDateTime;

public class Agendamento {
    private int id; 
    private Cliente cliente;
    private LocalDateTime dataHora;
    private Cortes corte;
    private Barbeiro barbeiro;
    private String status;
    private String senha;

    public Agendamento(int id, Cliente cliente, LocalDateTime dataHora, Cortes corte, Barbeiro barbeiro, String status, String senha) {
        this.id = id;
        this.cliente = cliente;
        this.dataHora = dataHora;
        this.corte = corte;
        this.barbeiro = barbeiro;
        this.status = status;
        this.senha = senha;
    }
    public Agendamento(Cliente cliente, LocalDateTime dataHora, Cortes corte, Barbeiro barbeiro, String status, String senha) {
        this.cliente = cliente;
        this.dataHora = dataHora;
        this.corte = corte;
        this.barbeiro = barbeiro;
        this.status = status;
        this.senha = senha;
    }
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Cortes getCorte() {
        return corte;
    }

    public void setCorte(Cortes corte) {
        this.corte = corte;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
