package forohub.api.topicos;


import java.time.LocalDateTime;


public record DetalleTopicoDTO (String titulo,
         String mensaje,
         LocalDateTime fechaCreacion,
         String status,
         String autor,
         String curso){

    public DetalleTopicoDTO(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }

}
