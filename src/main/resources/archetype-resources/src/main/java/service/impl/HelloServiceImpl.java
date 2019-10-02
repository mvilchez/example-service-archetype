package service.impl;

import domain.HelloResponse;
import service.HelloService;

/**
 * Implementación del servicio de Hola
 *
 * @author ${author}
 */
public class HelloServiceImpl implements HelloService {
    /**
     * Método que devuelve un mensaje de bienvenida junto con el nombre que se le pasa como parámetro
     * La implementación del servicio no es más que concatenar el nombre al mensaje "Hola, "
     *
     * @param nombre un string con el nombre
     * @return el mensaje completo
     */
    @Override
    public HelloResponse getMessage(String nombre) {
        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setMessage(String.format("Hola, %s", nombre));
        return helloResponse;
    }
}
