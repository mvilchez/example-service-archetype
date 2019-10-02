package web;

import domain.HelloResponse;
import domain.UnauthorizedResponse;
import service.HelloService;
import domain.ForbiddenResponse;
import domain.InternalErrorResponse;
import domain.NotFoundResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

/**
 * Hello controller
 * <p>
 * Ejemplo de un controlador REST. Implementa un método GET que devuelve un mensaje personalizado con el nombre
 * introducido como parámetro.
 * <p>
 * Se pretende que sea un ejemplo de cómo crear correctamente un controlador REST.
 * <p>
 * Documentado con Swagger 2, a continuación se indica a qué corresponde cada anotación de Swagger.
 * <pre>
 *     <ul>
 *          <li>@ApiOperation {@link ApiOperation}: Sirve para indicar una descripción del método y la clase que
 *          modela la respuesta.</li>
 *          <li>@ApiOperation {@link ApiOperation}: Sirve para indicar una descripción del método y la clase que modela
 *          la respuesta.</li>
 *          <li>@ApiResponse {@link ApiResponses}: Sirve para indicar una lista de respuestas que va devolver el
 *          servicio.</li>
 *          <li>@ApiImplicitParam {@link ApiImplicitParam}: Sirve para indicar que el servicio requiere un parámetro
 *          implícito. En este caso es en el header y se trata de la cabecera Authorization.</li>
 *          <li>@ApiParam {@link ApiParam}: Se usa para indicar la descripción de un parámetro del controlador</li>
 *      </ul>
 * </pre>
 *
 * @author ${author}
 */
@RestController
@Api(value = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Hello messages.",
        produces = "application/json", consumes = "application/json")
public class HelloController {
    /**
     * Interface de negocio que devuelve un mensaje de Hola
     */
    private final HelloService helloService;

    /**
     * Construtor por defecto
     *
     * @param helloService parámetro del controlador
     */
    public HelloController(final HelloService helloService) {
        this.helloService = helloService;
    }

    /**
     * Devuelve un mensaje de hola junto con el nombre que se pasa como parámetro de query
     *
     * @param name nombre que se añade al mensaje de hola
     * @return ResponseEntity con el DTO del mensaje
     */
    @ApiOperation(value = "Gets a hello resource. ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved hello resource",
                    response = HelloResponse.class),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource",
                    response = UnauthorizedResponse.class),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden",
                    response = ForbiddenResponse.class),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found",
                    response = NotFoundResponse.class),
            @ApiResponse(code = 500, message = "Internal Error",
                    response = InternalErrorResponse.class)
    })
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true,
            paramType = "header", example = "Bearer access_token")
    @GetMapping("/hello/{name}")
    public ResponseEntity hello(@ApiParam(value = "Name to say hello object", required = true) @PathVariable String name) {
        HelloResponse mensajeHola = helloService.getMessage(name);
        if (mensajeHola != null) {
            return new ResponseEntity<>(mensajeHola, OK);
        } else {
            NotFoundResponse notFoundResponse = new NotFoundResponse();
            return new ResponseEntity<>(notFoundResponse, NOT_FOUND);
        }
    }
}
