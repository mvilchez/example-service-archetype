package ${package}.domain;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * Clase Response para errores UNAUTHORIZED
 * <p>
 * Tiene que ser serializable
 *
 * @author ${author}3
 * @see domain.DefaultErrorResponse
 */
public class UnauthorizedResponse extends DefaultErrorResponse implements Serializable {
    /**
     * Serial number. Es recomendable usar números aleatorios para que ambos lados del sistema (el que envía y el que
     * recibe la clase serializada) sean capaces de detectar que son dos objetos distintos de forma más rápida.
     */
    private static final long serialVersionUID = -7487650108762914331L;

    /**
     * Default constructor
     */
    public UnauthorizedResponse() {
        this.setErrorMessage("Not authorized");
        this.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}
