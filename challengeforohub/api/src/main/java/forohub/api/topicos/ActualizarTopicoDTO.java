package forohub.api.topicos;

import jakarta.validation.constraints.NotBlank;

public record ActualizarTopicoDTO(
        @NotBlank(message = "El titulo no puede estar vacio.")
        String titulo,

        @NotBlank(message = "El mensaje no puede estar vacio.")
        String mensaje,

        @NotBlank(message = "El autor no puede estar vacio.")
        String autor,

        @NotBlank(message = "El curso no puede estar vacio.")
        String curso) {
}
