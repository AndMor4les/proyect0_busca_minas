/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaminas.excepciones;

/**
 *
 * @author eve-d
 */
/**
 * Excepción personalizada para coordenadas inválidas en el juego Buscaminas.
 * Se lanza cuando el usuario ingresa coordenadas fuera del rango del tablero
 * o con un formato incorrecto (ej: "Z9" en un tablero 10x10).
 */
public class CoordenadaInvalidaException extends Exception {

    /**
     * Constructor con mensaje personalizado.
     * @param mensaje Descripción detallada del error (ej: "Coordenada fuera de rango").
     */
    public CoordenadaInvalidaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje por defecto.
     * Útil para errores genéricos de formato.
     */
    public CoordenadaInvalidaException() {
        super("Coordenada inválida. Use el formato LetraNúmero (ej: A5).");
    }
}