package modelo;

public class No {
    private Agendamento agendamento;
    private No proximo;

    public No(Agendamento agendamento) {
        this.agendamento = agendamento;
        this.proximo = null;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    

}

