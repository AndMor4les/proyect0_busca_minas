package buscaminas.modelo;

public class Casilla {
    // Atributos privados
    private boolean esMina;
    private boolean descubierta;
    private boolean marcada;
    private int minasAlrededor;

    // Constructor
    public Casilla() {
        this.esMina = false;
        this.descubierta = false;
        this.marcada = false;
        this.minasAlrededor = 0;
    }

    // Getters y Setters
    public boolean esMina() { return esMina; }
    public void setEsMina(boolean esMina) { this.esMina = esMina; }
    public boolean estaDescubierta() { return descubierta; }
    public void setDescubierta(boolean descubierta) { this.descubierta = descubierta; }
    public boolean estaMarcada() { return marcada; }
    public void setMarcada(boolean marcada) { this.marcada = marcada; }
    public int getMinasAlrededor() { return minasAlrededor; }
    public void setMinasAlrededor(int minasAlrededor) { this.minasAlrededor = minasAlrededor; }
}