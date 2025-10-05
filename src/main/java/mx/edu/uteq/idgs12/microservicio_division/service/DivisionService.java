package mx.edu.uteq.idgs12.microservicio_division.service;

import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;
    
    public Division editarDivision(Long id, Division divisionDetalles) {
        Division divisionExistente = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("División no encontrada"));

        divisionExistente.setNombre(divisionDetalles.getNombre());
        divisionExistente.setActivo(divisionDetalles.isActivo());

        return divisionRepository.save(divisionExistente);
    }
    
}
