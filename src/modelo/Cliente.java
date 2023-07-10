package modelo;

public class Cliente extends Utilizador {
    private String tipoCliente;
  

 
    public Cliente(String nome, String telefone, String tipoCliente) {
        super(nome, telefone, "cliente");
        this.tipoCliente = tipoCliente;
    }
    public Cliente(String nome) {
        super(nome,"","");
        
    }

  
    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
 
}
