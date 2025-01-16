package forohub.api.topicos;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "topicos")
@Entity(name = "Topico")
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    @Setter
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion; //LocalDateTime.now();

    private String status;

    private String autor;

    private String curso;


    public Topico(String titulo, String mensaje, String autor, String curso, String status) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.curso = curso;
        this.status = status;
        this.fechaCreacion = LocalDateTime.now();
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El titulo no puede estar vacio");
        }
        this.titulo = titulo;
    }

    public void setMensaje(String mensaje) {
        if (mensaje == null || mensaje.isBlank()) {
            throw new IllegalArgumentException("El mensaje no puede estar vacio");
        }
        this.mensaje = mensaje;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("El autor no puede estar vacio");
        }
        this.autor = autor;
    }

    public void setCurso(String curso) {
        if (curso == null || curso.isBlank()) {
            throw new IllegalArgumentException("El curso no puede estar vacio");
        }
        this.curso = curso;
    }

    public void setStatus(String status) {
        if (status == null || (!status.equalsIgnoreCase("Activo") && !status.equalsIgnoreCase("Inactivo"))) {
            throw new IllegalArgumentException("El estado debe estar activo o inactivo");
        }
        this.status = status;
    }


}
