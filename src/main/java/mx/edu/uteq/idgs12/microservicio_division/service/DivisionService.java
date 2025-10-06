package mx.edu.uteq.idgs12.microservicio_division.service;

import mx.edu.uteq.idgs12.microservicio_division.dto.DivisionDTO;
import mx.edu.uteq.idgs12.microservicio_division.entity.Division;
import mx.edu.uteq.idgs12.microservicio_division.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    public Division cambiarEstado(Long id, boolean activo) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("División no encontrada"));
        division.setActivo(activo);
        return divisionRepository.save(division);
    }
    
}
