package ${package}.domain;

/**
 * Clase por defecto para las respuestas de Error
 *
 * @author ${author}
 */
public class DefaultErrorResponse {
    /**
     * String que contiene el mensaje de error
     */
    private String errorMessage;
    /**
     * integer que contiene código http de respuesta
     */
    private int status;

    /**
     * Gets error message
     *
     * @return error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets error message
     *
     * @param errorMessage string to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Gets status code
     *
     * @return status code
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets status code
     *
     * @param status status code to be set
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
