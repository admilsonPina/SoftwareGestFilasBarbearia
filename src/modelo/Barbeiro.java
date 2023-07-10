package modelo;


public class Barbeiro extends Utilizador {
    private String especialidade;
    private String moradaBarber;
    private String CNIBarber;

 
    public Barbeiro(String nome, String telefone, String especialidade, String moradaBarber,
		String cNIBarber) {
		super(nome, telefone, "Barbeiro");
		this.especialidade = especialidade;
		this.moradaBarber = moradaBarber;
		this.CNIBarber = cNIBarber;
	}
	
	public Barbeiro(String nome, String telefone, String especialidade) {
        super(nome, telefone, "barbeiro");
        this.especialidade = especialidade;
    }
    public Barbeiro(String nome) {
        super(nome,"","");
        
    }
   
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public String getMoradaBarber() {
		return moradaBarber;
	}
	public void setMoradaBarber(String moradaBarber) {
		this.moradaBarber = moradaBarber;
	}
	public String getCNIBarber() {
		return CNIBarber;
	}
	public void setCNIBarber(String cNIBarber) {
		CNIBarber = cNIBarber;
	}
   
}
