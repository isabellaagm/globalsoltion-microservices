package br.com.fiap.ra_552327.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ra_552327.dto.VoluntarioRequestCreate;
import br.com.fiap.ra_552327.dto.VoluntarioRequestUpdate;
import br.com.fiap.ra_552327.dto.VoluntarioResponse;
import br.com.fiap.ra_552327.service.VoluntarioService;

@RestController
@RequestMapping("voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    @PostMapping
    public ResponseEntity<VoluntarioResponse> create(@RequestBody VoluntarioRequestCreate dto) {                                    
        return ResponseEntity.status(201).body(
            new VoluntarioResponse().toDto(
                voluntarioService.createVoluntario(dto)
            )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = voluntarioService.deleteVoluntario(id);

        if (result) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }     
    }

    @PutMapping("/{id}")
    public ResponseEntity<VoluntarioResponse> update(@PathVariable Long id, @RequestBody VoluntarioRequestUpdate dto) {
        
        return voluntarioService.updateVoluntario(dto, id)
            .map(p-> new VoluntarioResponse().toDto(p))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoluntarioResponse> findById(@PathVariable Long id) {
        return voluntarioService.getVoluntarioById(id)
            .map(p-> new VoluntarioResponse().toDto(p))
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());     
    }

    @GetMapping
    public ResponseEntity<List<VoluntarioResponse>> findAll() {
        List<VoluntarioResponse> response = 
            voluntarioService.getAll().stream()
            .map(p-> new VoluntarioResponse().toDto(p))
            .collect(Collectors.toList()); 
        return ResponseEntity.ok(response);
    }
}
