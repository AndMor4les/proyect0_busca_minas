/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaminas.controlador;

/**
 *
 * @author eve-d
 */

import buscaminas.modelo.Tablero;
import buscaminas.vista.VistaConsola;

public class Juego {
    private Tablero tablero;
    private VistaConsola vista;
    private boolean juegoTerminado;

    public void iniciarJuego() {
        tablero = new Tablero(10, 10, 10); // Tablero 10x10 con 10 minas
        vista = new VistaConsola();
        juegoTerminado = false;

        while (!juegoTerminado) {
            vista.mostrarTablero(tablero, false);
            String opcion = vista.mostrarMenu();

            if (opcion.equals("3")) {
                System.out.println("¡Hasta luego!");
                break;
            }

            try {
                if (opcion.equals("1")) {
                    int[] coords = vista.obtenerCoordenada("Ingrese coordenadas para descubrir:");
                    if (coords != null && tablero.descubrirCasilla(coords[0], coords[1])) {
                        vista.mostrarTablero(tablero, true);
                        System.out.println("¡Perdiste! Has pisado una mina.");
                        juegoTerminado = true;
                    }
                } else if (opcion.equals("2")) {
                    int[] coords = vista.obtenerCoordenada("Ingrese coordenadas para marcar:");
                    if (coords != null) {
                        tablero.marcarCasilla(coords[0], coords[1]);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}