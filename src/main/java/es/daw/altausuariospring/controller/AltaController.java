package es.daw.altausuariospring.controller;

import es.daw.altausuariospring.dto.UsuarioDtoRecord;
import es.daw.altausuariospring.service.OpcionesService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AltaController {

    private final OpcionesService opcionesService;

    // Inyección por constructor: Spring proporciona el servicio.
    public AltaController(OpcionesService opcionesService) {
        this.opcionesService = opcionesService;
    }

    @GetMapping("/")
    public String inicio() {
        return "index"; // Spring resuelve la vista en templates/index.html.
    }

    // Estos métodos se ejecutan antes de cada petición y dejan las opciones disponibles en el Model.
    // Así no repetimos la carga de listas en el GET y en el POST que vuelve con errores.
    @ModelAttribute("tecnologias")
    public List<String> cargarTecnologias() {
        return opcionesService.getTecnologias();
    }

    @ModelAttribute("listaNiveles")
    public List<String> cargarNiveles() {
        return opcionesService.getNiveles();
    }

    @GetMapping("/alta")
    public String mostrarFormulario(@ModelAttribute("usuario") UsuarioDtoRecord usuario) {
        // Spring crea un DTO vacío para que th:object pueda pintar el formulario.
        return "formulario";
    }

    @PostMapping("/alta")
    public String procesarFormulario(
            @Valid @ModelAttribute("usuario") UsuarioDtoRecord usuario,
            BindingResult bindingResult) {
        // BindingResult debe ir justo después del DTO: Spring coloca aquí los errores de binding y validación.
        if (bindingResult.hasErrors()) {
            return "formulario"; // Thymeleaf conserva los valores y muestra los errores de cada campo.
        }

        return "confirmacion"; // El DTO usuario queda disponible en la vista.
    }
}
