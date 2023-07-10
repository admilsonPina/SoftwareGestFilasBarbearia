package modelo;

public class Utilizador {
    private int id;
    private String nome;
    private String telefone;
    private String tipoUtilizador;

    public Utilizador(String nome, String telefone, String tipoUtilizador) {
        this.nome = nome;
        this.telefone = telefone;
        this.tipoUtilizador = tipoUtilizador;
    }

    // getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoUtilizador() {
        return tipoUtilizador;
    }

    public void setTipoUtilizador(String tipoUtilizador) {
        this.tipoUtilizador = tipoUtilizador;
    }
}