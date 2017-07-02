package model;

public class Carro {

    private int portas;
    private String placa;
    private String modelo;
    private String cor;
    private String disponivel;
    private boolean arCondicionado;
    private boolean trava;
    private boolean vidro;
    private boolean automatico;
    private double valor;
    private String alugadoPor;

    public Carro(String placa) {
        this.placa = placa;
    }

    public Carro(String placa, String cor, int portas, boolean automatico, double valor, String modelo, boolean trava,
            boolean arCondicionado, boolean vidro, String disponivel) {
        this.portas = portas;
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.arCondicionado = arCondicionado;
        this.trava = trava;
        this.vidro = vidro;
        this.automatico = automatico;
        this.valor = valor;
        this.disponivel = disponivel;
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public boolean isTrava() {
        return trava;
    }

    public void setTrava(boolean trava) {
        this.trava = trava;
    }

    public boolean isVidro() {
        return vidro;
    }

    public void setVidro(boolean vidro) {
        this.vidro = vidro;
    }

    public boolean isAutomatico() {
        return automatico;
    }

    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDisponibilidade() {
        return disponivel;
    }

    public void setDisponibilidade(String disponivel) {
        this.disponivel = disponivel;
    }

    public String getAlugadoPor() {
        return alugadoPor;
    }

    public void setAlugadoPor(String alugadoPor) {
        this.alugadoPor = alugadoPor;
    }

}
