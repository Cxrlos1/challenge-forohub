package forohub.api.security;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank(message = "El usuario es obligatorio") String username,

        @NotBlank(message = "La contraseña es obligatoria") String password) {
}
