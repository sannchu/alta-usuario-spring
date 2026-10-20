package es.daw.altausuariospring.dto;


import lombok.*;

import java.util.ArrayList;
import java.util.List;
/** DTO del formulario: Spring lo rellena con data binding y Bean Validation comprueba sus campos. */


@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UsuarioDto {
    private String nombre;
    private String email;
    private String tecnologia;
    private List<String> niveles = new ArrayList<>();


}
