package domain;

import java.io.Serializable;

/**
 * Data Transfer Object class
 * Tiene que ser serializable
 *
 * @author ${author}
 */
public class HelloResponse implements Serializable {
    /**
     * Serial number. Es recomendable usar números aleatorios para que ambos lados del sistema (el que envía y el que
     * recibe la clase serializada) sean capaces de detectar que son dos objetos distintos de forma más rápida.
     */
    private static final long serialVersionUID = 4514520060491687849L;
    /**
     * String que contiene el mensaje de Hola
     */
    private String message;

    /**
     * Getter
     *
     * @return hello message in a String
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter
     *
     * @param message String to set the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
