package com.aluracursos.forohub.controlador;

import com.aluracursos.forohub.modelo.Topico;
import com.aluracursos.forohub.repositorio.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Topico> crearTopico(@RequestBody @Valid Topico topico) {
        if (topicoRepository.findByTituloAndMensaje(topico.getTitulo(), topico.getMensaje()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        topicoRepository.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(topico);
    }

    @GetMapping
    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> detalleTopico(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .map(topico -> ResponseEntity.ok(topico))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid Topico topicoActualizado) {
        return topicoRepository.findById(id)
                .map(topico -> {
                    topico.setTitulo(topicoActualizado.getTitulo());
                    topico.setMensaje(topicoActualizado.getMensaje());
                    topico.setEstado(topicoActualizado.getEstado());
                    topicoRepository.save(topico);
                    return ResponseEntity.ok(topico);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> eliminarTopico(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .map(topico -> {
                    topicoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
