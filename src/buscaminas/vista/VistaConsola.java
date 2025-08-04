/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaminas.vista;

/**
 *
 * @author eve-d
 */


import buscaminas.modelo.Tablero;
import buscaminas.excepciones.CoordenadaInvalidaException;
import java.util.Scanner;

/**
 * Clase que maneja la interacción con el usuario en la consola
 * Implementa la vista del patrón MVC para el juego Buscaminas
 */
public class VistaConsola {
    private final Scanner scanner;
    
    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el tablero de juego en la consola
     * @param tablero El tablero a mostrar
     * @param mostrarMinas Si es true, muestra las minas (para fin de juego)
     */
    public void mostrarTablero(Tablero tablero, boolean mostrarMinas) {
        // Encabezado con números de columnas
        System.out.print("  ");
        for (int i = 1; i <= tablero.getColumnas(); i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();

        // Filas del tablero
        for (int i = 0; i < tablero.getFilas(); i++) {
            // Letra de la fila
            System.out.print((char)('A' + i) + " ");
            
            for (int j = 0; j < tablero.getColumnas(); j++) {
                if (tablero.getCasilla(i, j).estaDescubierta()) {
                    if (tablero.getCasilla(i, j).esMina()) {
                        System.out.print(" X ");
                    } else {
                        System.out.printf("%2d ", tablero.getCasilla(i, j).getMinasAlrededor());
                    }
                } else if (tablero.getCasilla(i, j).estaMarcada()) {
                    System.out.print(" M ");
                } else if (mostrarMinas && tablero.getCasilla(i, j).esMina()) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Muestra el menú principal y obtiene la opción del usuario
     * @return La opción seleccionada ("1", "2" o "3")
     */
    public String mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Descubrir casilla");
        System.out.println("2. Marcar/Desmarcar casilla");
        System.out.println("3. Salir del juego");
        System.out.print("Seleccione una opción (1-3): ");
        
        String opcion;
        do {
            opcion = scanner.nextLine().trim();
            if (!opcion.matches("[1-3]")) {
                System.out.print("Opción inválida. Por favor ingrese 1, 2 o 3: ");
            }
        } while (!opcion.matches("[1-3]"));
        
        return opcion;
    }

    /**
     * Obtiene coordenadas del usuario con validación
     * @param mensaje Mensaje a mostrar al usuario
     * @return Arreglo con las coordenadas [fila, columna]
     * @throws CoordenadaInvalidaException Si las coordenadas son inválidas
     */
    public int[] obtenerCoordenada(String mensaje) throws CoordenadaInvalidaException {
        System.out.print(mensaje);
        String input = scanner.nextLine().trim().toUpperCase();
        
        // Validar formato básico (letra seguida de número)
        if (!input.matches("^[A-J][1-9]|10$")) {
            throw new CoordenadaInvalidaException("Formato inválido. Use letra (A-J) seguida de número (1-10), ej: A5");
        }
        
        try {
            char letra = input.charAt(0);
            int fila = letra - 'A';
            int columna = Integer.parseInt(input.substring(1)) - 1;
            
            // Validar rango (aunque el regex ya lo hace en parte)
            if (fila < 0 || fila >= 10 || columna < 0 || columna >= 10) {
                throw new CoordenadaInvalidaException("Coordenadas fuera de rango. Use de A1 a J10.");
            }
            
            return new int[]{fila, columna};
        } catch (NumberFormatException e) {
            throw new CoordenadaInvalidaException("Número de columna inválido. Use valores del 1 al 10.");
        }
    }

    /**
     * Muestra un mensaje al usuario
     * @param mensaje El mensaje a mostrar
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}