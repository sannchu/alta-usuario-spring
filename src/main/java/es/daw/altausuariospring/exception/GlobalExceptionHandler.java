package es.daw.altausuariospring.exception;


import org.slf4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Centraliza el tratamiento del error en lugar de repetir try/catch en cada método del controlador.
    @ExceptionHandler(FicheroNoEncontradoException.class)
    public String gestionarErrorFichero(FicheroNoEncontradoException e, Model model) {
        LOG.error("Error al leer el fichero: " + e);
        model.addAttribute("mensajeError", e.getMessage());
        return "error";
    }
}
