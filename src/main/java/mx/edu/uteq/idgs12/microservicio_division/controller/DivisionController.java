package mx.edu.uteq.idgs12.microservicio_division.controller;

import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionDTO;
import mx.edu.uteq.idgs12.microservicio_division.entity.ProgramaEducativo;
import mx.edu.uteq.idgs12.microservicio_division.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/divisiones")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    @PostMapping
    public DivisionDTO agregarDivision(@RequestBody DivisionDTO divisionDTO) {
        return divisionService.agregarDivision(divisionDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DivisionDTO> editarDivision(@PathVariable Long id, @RequestBody DivisionDTO divisionDTO) {
        DivisionDTO actualizada = divisionService.editarDivision(id, divisionDTO);
        return ResponseEntity.ok(actualizada);
    }



    @PutMapping("/programa-educativo/{id}")
    public ResponseEntity<ProgramaEducativo> editarProgramaEducativo(
            @PathVariable Long id,
            @RequestBody ProgramaEducativo detalles) {

        ProgramaEducativo actualizado = divisionService.editarProgramaEducativo(id, detalles);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/programa-educativo/{id}")
    public ResponseEntity<Void> eliminarProgramaEducativo(@PathVariable Long id) {
        divisionService.eliminarProgramaEducativo(id);
        return ResponseEntity.noContent().build();
    }
}
