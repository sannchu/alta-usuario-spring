package es.daw.altausuariospring.service;


import es.daw.altausuariospring.exception.FicheroNoEncontradoException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class OpcionesService {
    // Las opciones viven en resources/datos y se leen desde el classpath.
    public List<String> getTecnologias() { return leerFichero("datos/tecnologias.txt"); }
    public List<String> getNiveles()     { return leerFichero("datos/niveles.txt"); }

    private List<String> leerFichero(String ruta) {
        // En el Servlet se obtenía el recurso con ServletContext; ahora ClassPathResource busca en el classpath.
        // resources/datos no es una carpeta pública como static: el navegador no puede pedir estos ficheros por URL.
        ClassPathResource recurso = new ClassPathResource(ruta);
        if (!recurso.exists()) {
            throw new FicheroNoEncontradoException("No se encuentra el fichero " + ruta);
        }
        // try-with-resources cierra el flujo también si ocurre un error al leerlo; usamos UTF-8 explícitamente.
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(recurso.getInputStream(), StandardCharsets.UTF_8))) {
            // lines() crea un flujo de líneas: quitamos las vacías, recortamos espacios y reunimos el resultado en una lista.
            return br.lines().filter(l -> !l.isBlank()).map(String::trim).toList();
        } catch (IOException e) {
            throw new FicheroNoEncontradoException("Error leyendo " + ruta, e);
        }
    }
}
