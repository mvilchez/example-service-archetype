import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Aplicación Spring Boot
 * Arranca la app y extiende de {@link SpringBootServletInitializer} porque es un servicio que se desplegará en un
 * contenedor web
 *
 * @author ${author}
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    /**
     * Parámetro estático para la clase principal del servicio
     */
    private static Class<Application> applicationClass = Application.class;

    /**
     * Método principal
     *
     * @param args args
     */
    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }

    /**
     * Sobreescribe el método configure de la clase {@link SpringBootServletInitializer} para poder desplegarse en un
     * contenedor web
     *
     * @param application la clase {@link SpringApplicationBuilder}
     * @return la clase {@link SpringApplicationBuilder} modificada
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
}
