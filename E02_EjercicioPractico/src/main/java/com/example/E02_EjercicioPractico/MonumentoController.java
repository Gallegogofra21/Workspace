package com.example.E02_EjercicioPractico;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/monumento")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Monumento>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monumento> findOne(@PathVariable("id") Long id) {

        return ResponseEntity.of(repository.findById(id));
    }

    @PostMapping("/") // Si ponemos solo el objeto el tipo de respuesta será siempre 200, por eso usamos ResponseEntity
    public ResponseEntity<Monumento> create(@RequestBody Monumento monumento) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                //.status(201)
                .body(repository.save(monumento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monumento> edit(@RequestBody Monumento monumento, @PathVariable Long id) {

        /*Monumento antiguo = repository.findById(id).orElse(monumento);
        antiguo.setCodigoPais(monumento.getCodigoPais());
        antiguo.setNombrePais(monumento.getNombrePais());
        antiguo.setNombreCiudad(monumento.getNombreCiudad());
        antiguo.setLatitud(monumento.getLatitud());
        antiguo.setLongitud(monumento.getLongitud());
        antiguo.setNombreMonumento(monumento.getNombreMonumento());
        antiguo.setDescripcion(monumento.getDescripcion());
        antiguo.setUrlFoto(monumento.getUrlFoto());*/

        return ResponseEntity.of(
        repository.findById(id).map(antiguo -> {
            antiguo.setCodigoPais(monumento.getCodigoPais());
            antiguo.setNombreMonumento(monumento.getNombreMonumento());
            antiguo.setDescripcion(monumento.getDescripcion());
            antiguo.setLatitud(monumento.getLatitud());
            antiguo.setLongitud(monumento.getLongitud());
            antiguo.setNombreCiudad(monumento.getNombreCiudad());
            antiguo.setNombrePais(monumento.getNombrePais());
            antiguo.setUrlFoto(monumento.getUrlFoto());
            repository.save(antiguo);
            return antiguo;
             })
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
