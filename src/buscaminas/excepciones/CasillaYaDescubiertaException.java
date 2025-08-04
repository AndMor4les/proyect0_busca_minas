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
 * Excepción personalizada que se lanza cuando un jugador intenta
 * descubrir una casilla que ya ha sido revelada previamente.
 * 
 * Esta excepción ayuda a manejar casos específicos del juego Buscaminas
 * donde la acción del usuario no es válida según las reglas del juego.
 */
public class CasillaYaDescubiertaException extends Exception {

    /**
     * Constructor con mensaje por defecto.
     * El mensaje indica que la casilla ya está descubierta.
     */
    public CasillaYaDescubiertaException() {
        super("La casilla seleccionada ya ha sido descubierta.");
    }

    /**
     * Constructor con mensaje personalizado.
     * @param mensaje El mensaje de error específico que se desea mostrar.
     */
    public CasillaYaDescubiertaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor con mensaje y causa.
     * @param mensaje El mensaje de error específico.
     * @param causa La excepción que originó este error (para mantener el stack trace).
     */
    public CasillaYaDescubiertaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
