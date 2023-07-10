package modelo;

import java.time.Duration;

public class Cortes {
	private int id; 
    private String tipoCorte;
    private Duration duracao;
    private double custo;

    public Cortes(int id ,String tipoCorte, Duration duracao, double custo) {
        this.tipoCorte = tipoCorte;
        this.duracao = duracao;
        this.custo = custo;
        this.id = id ;
    }

    public String getTipoCorte() {
        return tipoCorte;
    }

    public void setTipoCorte(String tipoCorte) {
        this.tipoCorte = tipoCorte;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

	public int getId() {
		
		return id;
	}
}

