package mx.edu.uteq.idgs12.microservicio_division.controller;

import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/divisiones")
@CrossOrigin(origins = "*")
public class DivisionController {
   
 @Autowired 
 private DivisionService divisionService;

   //@GetMapping
   //public List<DivisionToViewListDo> getAllDivisiones(){
     // return divisionesService.findAll();
   //}

    @GetMapping
    public List<Division> getAllDivisiones() {
        return divisionService.findAll();
    }

  @GetMapping("/habilitadas")
    public List<Division> getHabilitadas() {
        return divisionService.findHabilitadas();
    }

     //  Deshabilitar
    @PutMapping("/{id}/deshabilitar")
    public ResponseEntity<Division> disable(@PathVariable Long id) {
        Division d = divisionService.disable(id);
        return d != null ? ResponseEntity.ok(d) : ResponseEntity.notFound().build();
    }

    //  Habilitar
    @PutMapping("/{id}/habilitar")
    public ResponseEntity<Division> enable(@PathVariable Long id) {
        Division d = divisionService.enable(id);
        return d != null ? ResponseEntity.ok(d) : ResponseEntity.notFound().build();
    }
     
}
