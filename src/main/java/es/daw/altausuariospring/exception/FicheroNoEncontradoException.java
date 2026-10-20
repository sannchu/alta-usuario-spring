package es.daw.altausuariospring.exception;

// Al ser unchecked, no obliga a poner try/catch en cada controlador; la gestiona GlobalExceptionHandler.
public class FicheroNoEncontradoException extends RuntimeException {
    public FicheroNoEncontradoException(String message) {

        super(message);
    }
    public FicheroNoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}
