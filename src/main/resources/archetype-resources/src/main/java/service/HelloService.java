package ${package}.service;

import ${package}.domain.HelloResponse;

/**
 * Interface del servicio de Hola
 *
 * @author ${author}
 */
public interface HelloService {
    /**
     * Método que devuelve un mensaje de bienvenida junto con el nombre que se le pasa como parámetro
     * @param nombre un string con el nombre
     * @return el mensaje completo
     */
    HelloResponse getMessage(String nombre);
}
