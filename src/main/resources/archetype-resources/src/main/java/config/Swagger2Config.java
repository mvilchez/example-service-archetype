package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Clase de configuración de Swagger.
 * Necesita una variable en el fichero de propiedades para decidir si activa el endpoint de acceso o no. Es falso si
 * no aparece en el fichero.
 *
 * @author ${author}
 * @see Value
 * @see Configuration
 * @see EnableSwagger2
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * Atributo privado para activar o desactivar swagger. Se recomienda poner un valor por defecto, por ejemplo:
     * <code>@Value("$ { swagger.enabled:false }")</code>
     */
    @Value("${swagger.enabled}")
    private boolean enabled;

    /**
     * Bean para configurar los endpoints que estarán expuestos por Swagger
     *
     * @return el bean para construir los endpoints
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enabled)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
