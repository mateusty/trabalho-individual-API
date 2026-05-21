package org.serratec.trabalhoIndividual.controller;

import jakarta.validation.Valid;
import org.serratec.trabalhoIndividual.entity.Veiculo;
import org.serratec.trabalhoIndividual.model.VeiculoInput;
import org.serratec.trabalhoIndividual.model.VeiculoResponse;
import org.serratec.trabalhoIndividual.model.VeiculoUpdateInput;
import org.serratec.trabalhoIndividual.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<Void> postVeiculo(@Valid @RequestBody VeiculoInput veiculo) {
        this.veiculoService.postVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponse>> getVeiculo(@RequestParam(required = false) String placa,
                                                            @RequestParam(required = false) String marca,
                                                            @RequestParam(required = false) String modelo) {
        return ResponseEntity.ok(this.veiculoService.getVeiculo(placa, marca, modelo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putVeiculo(@Valid @RequestBody VeiculoUpdateInput veiculo,
                                           @PathVariable UUID id) {
        this.veiculoService.putVeiculo(id, veiculo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable UUID id) {
        this.veiculoService.deleteVeiculo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
