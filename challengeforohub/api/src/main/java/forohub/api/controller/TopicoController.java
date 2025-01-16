package forohub.api.controller;


import forohub.api.repository.TopicoRepository;
import forohub.api.topicos.ActualizarTopicoDTO;
import forohub.api.topicos.DetalleTopicoDTO;
import forohub.api.topicos.NuevoTopicoDTO;
import forohub.api.topicos.Topico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<String> registrarTopico(@Valid @RequestBody NuevoTopicoDTO nuevoTopicoDTO){
      boolean existe = topicoRepository.existsByTituloAndMensaje(nuevoTopicoDTO.titulo(), nuevoTopicoDTO.mensaje());
      if (existe){
          return ResponseEntity.badRequest().body("El topico ya existe con el mismo titulo y mensaje");
      }

      Topico nuevoTopico = new Topico(
              nuevoTopicoDTO.titulo(),
              nuevoTopicoDTO.mensaje(),
              nuevoTopicoDTO.autor(),
              nuevoTopicoDTO.curso(),
              "Activo"
      );

      topicoRepository.save(nuevoTopico);

      return ResponseEntity.ok("Topico registrado exitosamente");
    }

    @GetMapping
    public ResponseEntity<List<DetalleTopicoDTO>> listarTopicos(){
        var topicos = topicoRepository.findAll().stream()
                .map(DetalleTopicoDTO::new)
                .toList();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleTopicoDTO> detallarTopico(@PathVariable Long id){
        var topico = topicoRepository.findById(id);
        if (topico.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new DetalleTopicoDTO(topico.get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarTopico(@PathVariable Long id, @Valid @RequestBody ActualizarTopicoDTO actualizarTopicoDTO){
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Topico topico = topicoOptional.get();

        topico.setTitulo(actualizarTopicoDTO.titulo());
        topico.setMensaje(actualizarTopicoDTO.mensaje());
        topico.setAutor(actualizarTopicoDTO.autor());
        topico.setCurso(actualizarTopicoDTO.curso());

        topicoRepository.save(topico);

        return ResponseEntity.ok("Topico actualizado exitosamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTopico(@PathVariable Long id){
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        topicoRepository.deleteById(id);

        return ResponseEntity.ok("Topico eliminado existosamente");
    }
}
