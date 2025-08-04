package buscaminas.modelo;
import java.util.Random;

public class Tablero {
    private Casilla[][] casillas;
    private int filas;
    private int columnas;
    private boolean juegoPerdido;

    public Tablero(int filas, int columnas, int totalMinas) {
        this.filas = filas;
        this.columnas = columnas;
        this.casillas = new Casilla[filas][columnas];
        this.juegoPerdido = false;
        inicializarTablero();
        colocarMinas(totalMinas);
        calcularMinasAlrededor();
    }

    private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla();
            }
        }
    }

    private void colocarMinas(int totalMinas) {
        Random rand = new Random();
        int minasColocadas = 0;
        
        while (minasColocadas < totalMinas) {
            int fila = rand.nextInt(filas);
            int columna = rand.nextInt(columnas);
            
            if (!casillas[fila][columna].esMina()) {
                casillas[fila][columna].setEsMina(true);
                minasColocadas++;
            }
        }
    }

    // Cambiado para devolver boolean (true si se pisó una mina)
    public boolean descubrirCasilla(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            return false;
        }

        Casilla casilla = casillas[fila][columna];
        
        if (casilla.estaMarcada() || casilla.estaDescubierta()) {
            return false;
        }

        casilla.setDescubierta(true);
        
        if (casilla.esMina()) {
            juegoPerdido = true;
            return true;
        }

        if (casilla.getMinasAlrededor() == 0) {
            // Descubrir casillas adyacentes automáticamente
            for (int i = Math.max(0, fila-1); i <= Math.min(fila+1, filas-1); i++) {
                for (int j = Math.max(0, columna-1); j <= Math.min(columna+1, columnas-1); j++) {
                    if (i != fila || j != columna) {
                        descubrirCasilla(i, j);
                    }
                }
            }
        }
        
        return false;
    }

    public void marcarCasilla(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            Casilla casilla = casillas[fila][columna];
            if (!casilla.estaDescubierta()) {
                casilla.setMarcada(!casilla.estaMarcada());
            }
        }
    }

    private void calcularMinasAlrededor() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casillas[i][j].esMina()) {
                    int count = 0;
                    for (int x = Math.max(0, i-1); x <= Math.min(i+1, filas-1); x++) {
                        for (int y = Math.max(0, j-1); y <= Math.min(j+1, columnas-1); y++) {
                            if (casillas[x][y].esMina()) count++;
                        }
                    }
                    casillas[i][j].setMinasAlrededor(count);
                }
            }
        }
    }

    // Métodos adicionales necesarios
    public Casilla getCasilla(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return casillas[fila][columna];
        }
        return null;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public boolean esJuegoPerdido() {
        return juegoPerdido;
    }

    public boolean esJuegoGanado() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Casilla casilla = casillas[i][j];
                if (!casilla.esMina() && !casilla.estaDescubierta()) {
                    return false;
                }
            }
        }
        return true;
    }
}