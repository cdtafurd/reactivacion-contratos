package com.indra.reactivacioncontratos.controllers;

import com.indra.reactivacioncontratos.models.Contrato;
import com.indra.reactivacioncontratos.repositories.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

    @Autowired
    ContratoRepository contratoRepository;

    @GetMapping
    public List<Contrato> obtenerTodos(){
        return contratoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Contrato obtener(@PathVariable Long id){
        return contratoRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Contrato> guardar(@RequestBody Contrato contrato){
        Contrato guardado = contratoRepository.save(contrato);
        return ResponseEntity.ok(guardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        contratoRepository.deleteById(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping
    public ResponseEntity<Contrato> actualizar(@RequestBody Contrato contrato){
        Contrato actualizar = contratoRepository.findById(contrato.getId()).get();
        actualizar.setNombre(contrato.getNombre());
        actualizar.setCodigo(contrato.getCodigo());
        return ResponseEntity.ok(contratoRepository.save(actualizar));
    }

}
