package es.daw.altausuariospring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;


public record UsuarioDtoRecord(

    @NotBlank
    @Size(min = 2, max = 50)
    String nombre,


    @NotBlank
    @Email
    String email,

    @NotBlank
    String tecnologia,

    @NotEmpty
    List<String> niveles
) {

}
