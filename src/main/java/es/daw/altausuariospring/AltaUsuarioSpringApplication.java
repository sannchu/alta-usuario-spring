package es.daw.altausuariospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AltaUsuarioSpringApplication {

    public static void main(String[] args) {
        // Spring Boot arranca la aplicación y su servidor Tomcat embebido; no se despliega un WAR manualmente.
        SpringApplication.run(AltaUsuarioSpringApplication.class, args);
    }

}
