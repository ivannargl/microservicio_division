package mx.edu.uteq.idgs12.microservicio_division.controller;

import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionDTO;
import mx.edu.uteq.idgs12.microservicio_division.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/divisiones")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;
    
    @PutMapping("/{id}")
    public ResponseEntity<DivisionDTO> editarDivision(@PathVariable Long id, @RequestBody DivisionDTO divisionDTO) {
        DivisionDTO actualizada = divisionService.editarDivision(id, divisionDTO);
        return ResponseEntity.ok(actualizada);
    }
    
}
